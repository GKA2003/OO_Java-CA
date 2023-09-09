package socialmedia;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;

/**
 * SocialMedia is a functioning implementor of
 * the SocialMediaPlatform interface.
 *
 * @author 720047329
 * @author 720060290
 * @version 1.0
 */
public class SocialMedia implements SocialMediaPlatform {

	/**
	 * The list of current accounts.
	 */
	ArrayList<Account> accountList = new ArrayList<>();
	/**
	 * The list of all posts.
	 */
	ArrayList<Post> postList = new ArrayList<>();
	/**
	 * The list of original posts.
	 */
	ArrayList<Post> originalPostList = new ArrayList<>();
	/**
	 * The list of endorsement posts.
	 */
	ArrayList<Post> endorseList = new ArrayList<>();
	/**
	 * The list comment posts.
	 */
	ArrayList<Post> commentList = new ArrayList<>();
	/**
	 * The list of deleted post ids.
	 */
	ArrayList<Post> deletedList = new ArrayList<>();

	/**
	 * Method to get the account list.
	 * @return ArrayList - the list of accounts.
	 */
	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	/**
	 * Method to get the post list.
	 * @return ArrayList - the list of posts.
	 */
	public ArrayList<Post> getPostList() {
		return postList;
	}

	/**
	 * Method to get the original post list.
	 * @return ArrayList - the list of original posts.
	 */
	public ArrayList<Post> getOriginalPostList() {
		return originalPostList;
	}

	/**
	 * Method to get the endorse list.
	 * @return ArrayList - the list of endorsements.
	 */
	public ArrayList<Post> getEndorseList() {
		return endorseList;
	}

	/**
	 * Method to get the comment list.
	 * @return ArrayList - the list of comments.
	 */
	public ArrayList<Post> getCommentList() {
		return commentList;
	}

	/**
	 * Method to get the deleted post list.
	 * @return ArrayList - the list of deleted posts.
	 */
	public ArrayList<Post> getDeletedList() {
		return deletedList;
	}

	/**
	 * The account id counter.
	 */
	private int idCounter = 0;
	/**
	 * The post id counter.
	 */
	private int postCounter = 0;

	/**
	 * Method to get check if an account exists.
	 * @param handle A String of the handle of an account.
	 * @return A Boolean - true if account exists, false if not.
	 */
	public Boolean checkForAccount(String handle) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getHandle().equals(handle)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to get check if an account exists.
	 * @param id An id of the handle of an account.
	 * @return A Boolean - true if account exists, false if not.
	 */
	public Boolean checkForAccount(int id) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to get check if a post exists.
	 * @param id An id of the handle of a post.
	 * @return A Boolean - true if post exists, false if not.
	 */
	public Boolean checkForPost(int id) {
		for (int i = 0; postList.size() > i; i++) {
			if (id == postList.get(i).getId()) {
				for (int j = 0; deletedList.size() > j; j++) {
					if (id == deletedList.get(j).getId()) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to get check if a post exists.
	 * @param id An id of the handle of a post.
	 * @return A Boolean - true if post exists, false if not.
	 */
	public Boolean checkForEndorsementPost(int id) {
		for (int i = 0; endorseList.size() > i; i++) {
			if (id == endorseList.get(i).getId()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method to get an Account object.
	 * @param handle A String of the handle of an account.
	 * @return An Account object of the account with the given handle, null otherwise.
	 */
	public Account getAccount(String handle) {
		System.out.println("String");
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getHandle().equals(handle)) {
				Account account = accountList.get(i);
				return account;
			}
		}
		return null;
	}

	/**
	 * Method to get an Account object.
	 * @param id An int of the id of an account.
	 * @return An Account object of the account with the given id, null otherwise.
	 */
	public Account getAccount(int id) {
		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getId() == id) {
				Account account = accountList.get(i);
				return account;
			}
		}
		return null;
	}

	/**
	 * Method to get a Post object from the master post list.
	 * @param id An int of the id of a post.
	 * @return A Post object of the post with the given id, null otherwise.
	 */
	public Post getPost(int id) {
		for (int i = 0; i < postList.size(); i++) {
			if (postList.get(i).getId() == id) {
				Post post = postList.get(i);
				return post;
			}
		}
		return null;
	}

	/**
	 * Method to get a Post object from the original post list.
	 * @param id An int of the id of a post.
	 * @return A Post object of the post with the given id, null otherwise.
	 */
	public Post getOriginalPost(int id) {
		for (int i = 0; i < originalPostList.size(); i++) {
			if (originalPostList.get(i).getId() == id) {
				Post post = originalPostList.get(i);
				return post;
			}
		}
		return null;
	}

	/**
	 * Method to get a Post object from the endorsement post list.
	 * @param id An int of the id of a post.
	 * @return A Post object of the post with the given id, null otherwise.
	 */
	public Post getEndorsementPost(int id) {
		for (int i = 0; i < endorseList.size(); i++) {
			if (endorseList.get(i).getId() == id) {
				Post post = endorseList.get(i);
				return post;
			}
		}
		return null;
	}

	/**
	 * Method to get a Post object from the comment post list.
	 * @param id An int of the id of a post.
	 * @return A Post object of the post with the given id, null otherwise.
	 */
	public Post getCommentPost(int id) {
		for (int i = 0; i < commentList.size(); i++) {
			if (commentList.get(i).getId() == id) {
				Post post = commentList.get(i);
				return post;
			}
		}
		return null;
	}

	/**
	 * Method to get a Post object from the deleted post list.
	 * @param id An int of the id of a post.
	 * @return A Post object of the post with the given id, null otherwise.
	 */
	public Post getDeletedPost(int id) {
		for (int i = 0; i < deletedList.size(); i++) {
			if (deletedList.get(i).getId() == id) {
				Post post = deletedList.get(i);
				return post;
			}
		}
		return null;
	}

	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {
		if (handle.length() == 0) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not be empty.");
		} else if (handle.length() > 30) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not have more than 30 characters.");
		} else if (handle.contains(" ")) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not contain whitespaces.");
		} else if (checkForAccount(handle)) {
			throw new InvalidHandleException("InvalidHandleException: a user with this handle already exists.");
		} else {
			Account account = new Account(idCounter++, handle);
			accountList.add(account);
			assert getAccount(handle) != null : "Account is not present in the account list.";
			return account.getId();
		}
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		if (handle.length() == 0) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not be empty.");
		} else if (handle.length() > 30) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not have more than 30 characters.");
		} else if (handle.contains(" ")) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not contain whitespaces.");
		} else if (checkForAccount(handle)) {
			throw new InvalidHandleException("InvalidHandleException: a user with this handle already exists.");
		} else {
			Account account = new Account(idCounter++, handle, description);
			accountList.add(account);
			assert getAccount(handle) != null : "Account is not present in the account list.";
			return account.getId();
		}
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		if (!checkForAccount(id)) {
			throw new AccountIDNotRecognisedException("AccountIDNotRecognisedException: an account with this ID does not exist.");
		} else {
			for (Post post : postList) {
				if (post.getAccount() != null && post.getAccount().getId() == id) {
					try {
						deletePost(post.getId());
					} catch (PostIDNotRecognisedException e) {
						// throw new RuntimeException(e);
					}
				}
			}
			accountList.removeIf(account -> account.getId() == id);
			assert getAccount(id) == null : "Account is still present in the account list.";
		}
	}


	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		if (!checkForAccount(handle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: an account with this handle does not exist.");
		} else {
			for (Post post : postList) {
				if (post.getAccount() != null && post.getAccount().getHandle() == handle) {
					try {
						deletePost(post.getId());
					} catch (PostIDNotRecognisedException e) {
						// throw new RuntimeException(e);
					}
				}
			}
			accountList.removeIf(account -> account.getHandle().equals(handle));
			assert getAccount(handle) == null : "Account is still present in the account list.";
		}
	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		if (!checkForAccount(oldHandle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: a user with this handle does not exist.");
		} else if (newHandle.length() == 0) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not be empty.");
		} else if (newHandle.length() > 30) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not have more than 30 characters.");
		} else if (newHandle.contains(" ")) {
			throw new IllegalHandleException("IllegalHandleException: the handle must not contain whitespaces.");
		} else if (checkForAccount(newHandle)) {
			throw new InvalidHandleException("InvalidHandleException: a user with this handle already exists.");
		} else {
			Account account = getAccount(oldHandle);
			account.setHandle(newHandle);
			assert getAccount(newHandle) != null : "Account is not present in the account list.";
		}

	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		if (!checkForAccount(handle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: a user with this handle does not exist.");
		} else {
			Account account = getAccount(handle);
			account.setDescription(description);
		}
	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		if (!checkForAccount(handle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: a user with this handle does not exist.");
		} else {
			Account account = getAccount(handle);
			return ("ID: " + account.getId() + "\nHandle: " + account.getHandle() +
					"\nDescription: " + account.getDescription() + "\nPost count: " + account.getPostCount() +
					"\nEndorse count: " + account.getEndorsementCount());
		}
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		if (!checkForAccount(handle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: a user with this handle does not exist.");
		} else if (message.length() == 0) {
			throw new InvalidPostException("InvalidPostException: the post cannot be empty.");
		} else if (message.length() > 100) {
			throw new InvalidPostException("InvalidPostException: message too long - cannot exceed 100 characters.");
		} else {
			// Post the message and then add to relevant lists and set appropriate attributes
			Post post = new Post(postCounter++, getAccount(handle), message);
			postList.add(post);
			originalPostList.add(post);
			getAccount(handle).increasePostCount();

			assert getPost(post.getId()) != null : "Post is not present in the post list.";
			assert getOriginalPost(post.getId()) != null : "Post is not present in the original post list.";

			return post.getId();
		}
	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		if (!checkForAccount(handle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: a user with this handle does not exist.");
		} else if (!checkForPost(id)) {
			throw new PostIDNotRecognisedException("PostIDNotRecognisedException: a post with this ID does not exist.");
		} else if (checkForEndorsementPost(id)) {
			throw new NotActionablePostException("NotActionablePostException: given ID refers to an endorsement post instead of the original post.");
		} else {
			// Get the post you are endorsing first
			Post oldPost = getPost(id);
			oldPost.increaseEndorsementCount();
			oldPost.getAccount().increaseEndorsementCount();

			// Post the endorsement
			String endorseContent = "EP@" + oldPost.getAccount().getHandle() + ": " + oldPost.getPostContent();
			Post endorsedPost = new Post(postCounter++, getAccount(handle), endorseContent);

			// Add to relevant lists and set appropriate attributes
			endorsedPost.setEndorsementPost(oldPost);
			endorseList.add(endorsedPost);
			postList.add(endorsedPost);
			getAccount(handle).increasePostCount();

			assert getPost(endorsedPost.getId()) != null : "Post is not present in the post list.";
			assert getEndorsementPost(endorsedPost.getId()) != null : "Post is not present in the endorsement post list.";

			return endorsedPost.getId();
		}
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		if (!checkForAccount(handle)) {
			throw new HandleNotRecognisedException("HandleNotRecognisedException: a user with this handle does not exist.");
		} else if (!checkForPost(id)) {
			throw new PostIDNotRecognisedException("PostIDNotRecognisedException: a post with this ID does not exist.");
		} else if (checkForEndorsementPost(id)) {
			throw new NotActionablePostException("NotActionablePostException: given ID refers to an endorsement post instead of the original post.");
		} else if (message.length() == 0) {
			throw new InvalidPostException("IllegalHandleException: the comment must not be empty.");
		} else if (message.length() > 100) {
			throw new InvalidPostException("IllegalHandleException: the comment must not have more than 100 characters.");
		} else {
			// Update parent post attributes and post the comment
			Post oldPost = getPost(id);
			oldPost.increaseCommentCount();
			Post commentPost = new Post(postCounter++, getAccount(handle), message);

			// Add to relevant lists and set appropriate attributes
			commentList.add(commentPost);
			postList.add(commentPost);
			getAccount(handle).increasePostCount();
			commentPost.setParentPost(oldPost);
			oldPost.setChildPost(commentPost);

			assert getPost(commentPost.getId()) != null : "Post is not present in the post list.";
			assert getCommentPost(commentPost.getId()) != null : "Post is not present in the comment post list.";

			return commentPost.getId();
		}
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		if (!checkForPost(id)) {
			throw new PostIDNotRecognisedException("PostIDNotRecognisedException: a post with this ID does not exist.");
		} else {
			Post ripPost = getPost(id);

			// Check if post being deleted is a comment
			// If so, remove these links and decrease comment count of parent
			if (ripPost.getParentPost() != null) {
				ripPost.getParentPost().removeChildPost(ripPost);
				ripPost.getParentPost().decreaseCommentCount();
			}

			// Find any endorsements of the post being deleted and remove them too
			Iterator<Post> iterator = endorseList.iterator();
			while (iterator.hasNext()) {
				Post post = iterator.next();
				if (post.getEndorsementPost() == ripPost) {
					iterator.remove();
					deletePost(post.getId());
					ripPost.getAccount().decreaseEndorsementCount();
				}
			}

			// Update relevant lists and attributes
			originalPostList.remove(ripPost);
			commentList.remove(ripPost);
			deletedList.add(ripPost);

			ripPost.setEndorsementCount(0);
			ripPost.getAccount().decreasePostCount();
			ripPost.setPostContent("The original content was removed from the system and is no longer available.");
			ripPost.setAccount(null);

			assert getOriginalPost(id) == null : "Post is still present in the original post list.";
			assert getEndorsementPost(id) == null : "Post is still present in the endorsement post list.";
			assert getCommentPost(id) == null : "Post is still present in the comment post list.";
			assert getDeletedPost(id) != null : "Post is not present in the deleted post list.";
		}
	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		if (!checkForPost(id)) {
			throw new PostIDNotRecognisedException("PostIDNotRecognisedException: a post with this ID does not exist.");
		} else {
			Post post = getPost(id);
			Account account = post.getAccount();
			return ("ID: " + post.getId() + "\nAccount: " + account.getHandle() + "\nNo. endorsements: " + post.getEndorsementCount() +
					" | No. comments: " + post.getCommentCount() + "\n" + post.getPostContent());
		}
	}

	/**
	 * Method to generate post threads for showPostChildrenDetails.
	 * @param returnString A StringBuilder to generate the thread in.
	 * @param childPosts An ArrayList of child posts for a post.
	 * @param recursionDepth An int of the recursion depth for indentation.
	 * @param firstComment A Boolean that's true if the post is the first comment under a post.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @return The complete StringBuilder thread.
	 */
	public StringBuilder addPostChildrenDetails(StringBuilder returnString, ArrayList<Post> childPosts, int recursionDepth, boolean firstComment) throws PostIDNotRecognisedException {
		String post;
		// Iterate through all the child posts
		for (Post p : childPosts) {
			int childPostId = p.getId();
			post = showIndividualPost(childPostId);

			// Update post returned so that formatting is suitable
			post = post.replace("\n", "\n" + "\t".repeat(recursionDepth));
			post = post.replace("ID:", "\n" + "\t".repeat(recursionDepth-1) + "| > ID:");

			// Determine if this is the first comment under a specific post to add an extra | character
			if (firstComment) {
				post = "\n" + "\t".repeat(recursionDepth-1) + "|" + post;
			}

			// Add post to StringBuilder and see if it has children
			returnString.append(post);
			ArrayList<Post> nextChildPosts = p.getChildPost();

			// If there are children, recursively call the function for them too
			if (!nextChildPosts.isEmpty()) {
				addPostChildrenDetails(returnString, nextChildPosts, ++recursionDepth, true);
				--recursionDepth;

			}
			firstComment = false;
		}
		return returnString;
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		if (!checkForPost(id)) {
			throw new PostIDNotRecognisedException("PostIDNotRecognisedException: a post with this ID does not exist.");
		} else if (checkForEndorsementPost(id)) {
			throw new NotActionablePostException("NotActionablePostException: given ID refers to an endorsement post instead of the original post.");
		} else {
			// Set StringBuilder max size to the total number of posts to ensure it is long enough
			int size = postList.size();
			StringBuilder returnString = new StringBuilder(size);

			// Add original post to StringBuilder
			String post = showIndividualPost(id);
			returnString.append(post);
			ArrayList<Post> childPosts = getPost(id).getChildPost();

			// Call addPostChildrenDetails() to add any comments to the StringBuilder
			if (childPosts != null) {
				addPostChildrenDetails(returnString, childPosts, 1, true);
			}

			return returnString;
		}
	}

	@Override
	public int getNumberOfAccounts() {
		return accountList.size();
	}

	@Override
	public int getTotalOriginalPosts() {
		return originalPostList.size();
	}

	@Override
	public int getTotalEndorsmentPosts() {
		return endorseList.size();
	}

	@Override
	public int getTotalCommentPosts() {
		return commentList.size();
	}

	@Override
	public int getMostEndorsedPost() {
		int max = 0;
		Post highestPost = null;
		for (Post post : postList) {
			if (post.getEndorsementCount() > max) {
				max = post.getEndorsementCount();
				highestPost = post;
			}
		}
		if (highestPost == null) {
			return -1;
		} else {
			return highestPost.getId();
		}
	}

	@Override
	public int getMostEndorsedAccount() {
		int max = 0;
		Account highestAccount = null;
		for (Account account : accountList) {
			if (account.getEndorsementCount() > max) {
				max = account.getEndorsementCount();
				highestAccount = account;
			}
		}
		if (highestAccount == null) {
			return -1;
		} else {
			return highestAccount.getId();
		}
	}

	@Override
	public void erasePlatform() {
		accountList.clear();
		postList.clear();
		originalPostList.clear();
		endorseList.clear();
		commentList.clear();
		deletedList.clear();

		idCounter = 0;
		postCounter = 0;
	}

	@Override
	public void savePlatform(String filename) throws IOException {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(accountList);
			objectOutputStream.writeObject(postList);
			objectOutputStream.writeObject(originalPostList);
			objectOutputStream.writeObject(endorseList);
			objectOutputStream.writeObject(commentList);
			objectOutputStream.writeObject(deletedList);
			objectOutputStream.writeObject(idCounter);
			objectOutputStream.writeObject(postCounter);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (IOException e) {
			throw new IOException("IOException: problem when trying to save contents to the file: " + filename);
		}

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			accountList = (ArrayList<Account>) objectInputStream.readObject();
			postList = (ArrayList<Post>) objectInputStream.readObject();
			originalPostList = (ArrayList<Post>) objectInputStream.readObject();
			endorseList = (ArrayList<Post>) objectInputStream.readObject();
			commentList = (ArrayList<Post>) objectInputStream.readObject();
			deletedList = (ArrayList<Post>) objectInputStream.readObject();
			idCounter = (int) objectInputStream.readObject();
			postCounter = (int) objectInputStream.readObject();
			objectInputStream.close();
		} catch (IOException e) {
			throw new IOException("IOException: problem when trying to load the file: " + filename);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("ClassNotFoundException: a required class file could not be found.");
		}
	}

}
