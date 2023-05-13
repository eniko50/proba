export class Record implements RecordInterface{

	public title: string;
	public imageUrl: string;
	public styles: string[];
	public author: string;
	public price: number;
		
	constructor(recordCfg:RecordInterface)
	{
		this.title = recordCfg.title;
		this.imageUrl = recordCfg.imageUrl;
		this.styles = recordCfg.styles;
		this.author = recordCfg.author;
		this.price = recordCfg.price;
	}
}

interface RecordInterface{
	title: string;
	imageUrl: string;
	styles: string[];
	author: string;
	price: number
}