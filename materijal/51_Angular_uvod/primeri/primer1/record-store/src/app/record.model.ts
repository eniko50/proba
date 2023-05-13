export class Record implements RecordInterface{

	public title: string;
	public imageUrl: string;
	public style: string[];
	public author: string;
		
	constructor(recordCfg:RecordInterface)
	{
		this.title = recordCfg.title;
		this.imageUrl = recordCfg.imageUrl;
		this.style = recordCfg.style;
		this.author = recordCfg.author;
	}
}

interface RecordInterface{
	title: string;
	imageUrl: string;
	style: string[];
	author: string
}