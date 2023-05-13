package com.luxa.test.web.controller;

import com.luxa.test.model.AuctionItem;
import com.luxa.test.model.Bid;
import com.luxa.test.service.AuctionItemService;
import com.luxa.test.service.BidService;
import com.luxa.test.web.dto.AuctionItemDTO;
import com.luxa.test.web.dto.BidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuctionItemController {

    @Autowired
    private AuctionItemService auctionItemService;

    @Autowired
    private BidService bidService;

    @GetMapping("/api/auctionItems")
    public ResponseEntity<List<AuctionItemDTO>> getAll() {
        List<AuctionItem> items = auctionItemService.findAll();

        List<AuctionItemDTO> dtos = items.stream()
                .map(AuctionItemDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    // Ovo nije moralo da se uradi u kontroleru.
    @GetMapping(value = "/api/auctionItems", params = "jmbg")
    public ResponseEntity<List<AuctionItemDTO>> findByJmbg(@RequestParam String jmbg) {
        List<AuctionItemDTO> items = auctionItemService.findByJmbg(jmbg).stream()
                .map(AuctionItemDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/api/auctionItems")
    public ResponseEntity<AuctionItemDTO> create(AuctionItemDTO createDto) {
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setName(createDto.getName());
        auctionItem.setBuyoutPrice(createDto.getBuyoutPrice());
        auctionItem.setMinimumBidPrice(createDto.getMinimumBidPrice());

        auctionItem = auctionItemService.save(auctionItem);

        AuctionItemDTO dto = new AuctionItemDTO(auctionItem);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping("/api/auctionItems/{id}/bids")
    public ResponseEntity<BidDTO> bid(@PathVariable long id, @RequestBody BidDTO dto) {
        AuctionItem auctionItem = auctionItemService.findById(id).orElseThrow(NumberFormatException::new);
        Bid bid = new Bid();
        bid.setPrice(dto.getPrice());
        bid.setFirstName(dto.getFirstName());
        bid.setLastName(dto.getLastName());
        bid.setJmbg(dto.getJmbg());

        Bid createdBid = bidService.createBidForItem(bid, auctionItem);

        BidDTO bidDto = new BidDTO(createdBid);
        bidDto.setItem(new AuctionItemDTO(auctionItem));

        return new ResponseEntity<>(bidDto, HttpStatus.OK);
    }
}
