export class Record implements RecordInterface{
	public id: number;
	public title: string;
	public imageUrl: string;
	public styles: StyleInterface[];
	public author: AuthorInterface;
	public price: number;
		
	constructor(recordCfg:RecordInterface)
	{
		this.id = recordCfg.id;
		this.title = recordCfg.title;
		this.imageUrl = recordCfg.imageUrl;
		this.styles = recordCfg.styles;
		this.author = recordCfg.author;
		this.price = recordCfg.price;
	}
}

interface RecordInterface{
	id?: number;
	title: string;
	imageUrl: string;
	styles: StyleInterface[];
	author: AuthorInterface;
	price: number
}

export interface AuthorInterface{
	id?: number;
	name?: string;
}

interface StyleInterface{
	id?: number;
	name?: string;
}