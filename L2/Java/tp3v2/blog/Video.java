package tp3v2.blog;

public class Video extends AbstractItem {
	private String url;

	public Video(long publicationDate, String author, String url) {
		super(publicationDate, author);
		this.url = url;
	}

	public String getURL() {
		return this.url;
	}
}