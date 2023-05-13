package com.luxa.test.web.controller;

import com.luxa.test.data.AuctionItemRepository;
import com.luxa.test.data.BidRepository;
import com.luxa.test.model.AuctionItem;
import com.luxa.test.model.Bid;
import com.luxa.test.web.dto.BidDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuctionItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionItemRepository auctionItemRepository;

    @After
    public void after() {
        bidRepository.deleteAll();
        auctionItemRepository.deleteAll();
    }

    @Test
    public void testBidding() {
        AuctionItem item = createAuctionItem("item", 100, 1000);

        String url = "/api/auctionItems/" + item.getId() + "/bids";
        BidDTO dto = new BidDTO(130, "Nikola", "Lukic", "mojjmbg");
        ResponseEntity<BidDTO> response = restTemplate.postForEntity(url, dto, BidDTO.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        final BidDTO responseDto = response.getBody();
        Assert.assertNotNull(responseDto);

        Assert.assertNotNull(responseDto.getItem());
        Assert.assertFalse(responseDto.getItem().isSold());
    }

    @Test
    public void testBiddingSold() {
        AuctionItem item = createAuctionItem("item", 100, 1000);

        String url = "/api/auctionItems/" + item.getId() + "/bids";
        BidDTO dto = new BidDTO(1300, "Nikola", "Lukic", "mojjmbg");
        ResponseEntity<BidDTO> response = restTemplate.postForEntity(url, dto, BidDTO.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        final BidDTO responseDto = response.getBody();
        Assert.assertNotNull(responseDto);

        Assert.assertNotNull(responseDto.getItem());
        Assert.assertTrue(responseDto.getItem().isSold());
    }

    @Test
    public void testBiddingSuccessMoreThanHighest() {
        AuctionItem item = createAuctionItem("item", 100, 1000);
        bidRepository.save(new Bid(200, "Nikola", "Lukic", "mojjmbg", item));

        String url = "/api/auctionItems/" + item.getId() + "/bids";
        BidDTO dto = new BidDTO(300, "Neko", "Drugi", "drugijmbg");
        ResponseEntity<BidDTO> response = restTemplate.postForEntity(url, dto, BidDTO.class);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        final BidDTO responseDto = response.getBody();
        Assert.assertNotNull(responseDto);

        Assert.assertNotNull(responseDto.getItem());
        Assert.assertFalse(responseDto.getItem().isSold());
    }

    @Test
    public void testBiddingFailLessThanMinimum() {
        AuctionItem item = createAuctionItem("item", 100, 1000);

        String url = "/api/auctionItems/" + item.getId() + "/bids";
        BidDTO dto = new BidDTO(90, "Nikola", "Lukic", "mojjmbg");
        ResponseEntity<Void> response = restTemplate.postForEntity(url, dto, Void.class);

        Assert.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    public void testBiddingFailLessThanHighestBid() {
        AuctionItem item = createAuctionItem("item", 100, 1000);
        bidRepository.save(new Bid(300, "Nikola", "Lukic", "mojjmbg", item));

        String url = "/api/auctionItems/" + item.getId() + "/bids";
        BidDTO dto = new BidDTO(200, "Neko", "Drugi", "drugijmbg");
        ResponseEntity<Void> response = restTemplate.postForEntity(url, dto, Void.class);

        Assert.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    private AuctionItem createAuctionItem(String name, int minimumBidPrice, int buyoutPrice) {
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setName(name);
        auctionItem.setMinimumBidPrice(minimumBidPrice);
        auctionItem.setBuyoutPrice(buyoutPrice);

        return auctionItemRepository.save(auctionItem);
    }
}