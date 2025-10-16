package tp3v2.blog;

import java.util.List;

public interface Taggable {
	void addTag(String tag);
	void removeTag(String tag);
	int tagCount();
	List<String> getTags();
}