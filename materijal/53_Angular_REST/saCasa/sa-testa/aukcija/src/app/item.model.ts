//{"id":1,"name":"Krevet","minimumBidPrice":100,"buyoutPrice":1000,"sold":false}

export interface Item {
    id: number;
    name: string;
    minimumBidPrice: number;
    buyoutPrice: number;
    sold: boolean;
}
