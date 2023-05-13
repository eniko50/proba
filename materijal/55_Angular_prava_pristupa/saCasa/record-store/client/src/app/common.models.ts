export class Record implements RecordInterface{
	public id: number;
	public title: string;
	public imageUrl: string;
	public styles: StyleInterface[];
	public author: AuthorInterface;
	public price: number;
		
	constructor(spec: RecordInterface)
	{
		this.id = spec.id;
		this.title = spec.title;
		this.imageUrl = spec.imageUrl;
		this.styles = spec.styles;
		this.author = spec.author;
		this.price = spec.price;
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

export enum Order{
  asc,
  desc
}
