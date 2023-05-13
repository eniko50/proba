export class Record implements RecordInterface{

	public title: string;
	public imageUrl: string;
	public styles: string[];
	public author: string;
		
	constructor(recordCfg:RecordInterface)
	{
		this.title = recordCfg.title;
		this.imageUrl = recordCfg.imageUrl;
		this.styles = recordCfg.styles;
		this.author = recordCfg.author;
	}
}

interface RecordInterface{
	title: string;
	imageUrl: string;
	styles: string[];
	author: string
}