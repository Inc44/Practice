package tp3v2.blog;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItem extends AbstractPublishableItem implements Taggable {
	private List<String> tags;

	public AbstractItem(long publicationDate, String author) {
		super(publicationDate, author);
		this.tags = new ArrayList<>();
	}

	@Override
	public void addTag(String tag) {
		if (tag != null && !this.tags.contains(tag)) {
			this.tags.add(tag);
		}
	}

	@Override
	public void removeTag(String tag) {
		this.tags.remove(tag);
	}

	@Override
	public int tagCount() {
		return this.tags.size();
	}

	@Override
	public List<String> getTags() {
		return this.tags;
	}
}