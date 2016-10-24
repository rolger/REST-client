package blogger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.cedarsoftware.util.io.JsonWriter;

public class BloggerClient {

	private WebTarget bloggerWebTarget;

	public BloggerClient() {
		Client client = ClientBuilder.newClient();
		bloggerWebTarget = client.target("http://localhost:8080/blogger/");
	}

	public static void main(String[] args) {
		getInstanz().runAll();
	}

	private static BloggerClient getInstanz() {
		return new BloggerClient();
	}

	private void runAll() {
		readAllBlogs();
		createNewPost("SOLID", "Robert C. Martin");
		addLikes("2", "Asterix");

		Response readAllResponse = bloggerWebTarget.path("posts").request(MediaType.APPLICATION_JSON).get();
		BlogPostCollection allPosts = readAllResponse.readEntity(BlogPostCollection.class);
		System.out.println("\nReading all post");
		for (BlogPost one : allPosts.getBlogPosts()) {
			printBlog(one);
		}
	}

	public BlogPost readBlogPost(String id) {
		Response response = bloggerWebTarget.path("posts/" + id).request(MediaType.APPLICATION_JSON).get();
		BlogPost blog = response.readEntity(BlogPost.class);

		printBlog(blog);

		return blog;
	}

	private void printBlog(BlogPost blogs) {
		System.out.println(blogs.getId() + ", " + //
				blogs.getAutor() + ", " + //
				blogs.getTitel() + ", " + //
				"#" + blogs.getLikes().size());
	}

	public void createNewPost(String title, String autor) {
		MultivaluedMap<String, String> postParam = new MultivaluedHashMap<String, String>();
		postParam.add("titel", title);
		postParam.add("autor", autor);
		Response response = bloggerWebTarget //
				.path("posts")//
				.request()//
				.post(Entity.form(postParam));

		System.out.println("\nCreated new post:");
		String location = response.getHeaderString("Location");
		readBlogPost(location.substring(location.lastIndexOf("/") + 1));
	}

	public void addLikes(String id, String name) {
		MultivaluedMap<String, String> postParam = new MultivaluedHashMap<String, String>();
		postParam.add("name", name);
		Response response = bloggerWebTarget//
				.path("posts/" + id + "/likes")//
				.request(MediaType.APPLICATION_JSON)//
				.post(Entity.form(postParam));

		System.out.println("\nAdded a like:");
		printBlog(response.readEntity(BlogPost.class));
	}

	public void readAllBlogs() {
		readAllBlogs(MediaType.APPLICATION_JSON);
		readAllBlogs(MediaType.APPLICATION_XML);
	}

	public void readAllBlogs(String mediaType) {
		Builder readAll = bloggerWebTarget.path("posts").request(mediaType);
		String result = readAll.get(String.class);
		if (mediaType.equals(MediaType.APPLICATION_JSON)) {
			result = JsonWriter.formatJson(result);
		}
		System.out.println(result);
	}

	public void deleteRequest(String id) {
		Response response= bloggerWebTarget.path("posts/" + id)//
				.request()//
				.delete();
		System.out.println(response.readEntity(String.class));
		System.out.println(response);
	}

	public void updatePost(String id, String title) {
		BlogPost blogPost = readBlogPost(id);
		blogPost.setTitel(title);
		blogPost.setAutor("unknown guy");

		Response response = bloggerWebTarget//
				.path("posts/" + id)//
				.request()
				.put(Entity.entity(blogPost, MediaType.APPLICATION_JSON));

		System.out.println(response);
	}

}
