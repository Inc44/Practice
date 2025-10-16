package tp3v2.blog;

public abstract class AbstractPublishableItem implements Publishable {
	private long publicationDate;
	private String author;

	public AbstractPublishableItem(long publicationDate, String author) {
		this.publicationDate = publicationDate;
		this.author = author;
	}

	@Override
	public long getPublicationDate() {
		return this.publicationDate;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}
}