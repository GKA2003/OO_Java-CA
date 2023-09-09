import socialmedia.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	/*
	public static void main(String[] args) {
		System.out.println("The system compiled and started the execution...");

		SocialMediaPlatform platform = new SocialMedia();

		assert (platform.getNumberOfAccounts() == 0) : "Initial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";

		try {
			int id1 = platform.createAccount("my_handle");
			int id2 = platform.createAccount("handle");
			assert (platform.getNumberOfAccounts() == 2) : "number of accounts registered in the system does not match";

			platform.removeAccount(id2);
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			System.out.println(platform.showAccount("my_handle"));

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
		} catch (AccountIDNotRecognisedException e) {
			assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		} catch (HandleNotRecognisedException e) {
			assert (false) : "HandleNotRecognisedException thrown incorrectly";
		}

		try {
			int post1 = platform.createPost("my_handle", "First ever post!");
			int post2 = platform.commentPost("my_handle", 0, "Second ever post!");

		} catch (HandleNotRecognisedException e) {
			System.out.println(e);
		} catch (InvalidPostException e) {
			System.out.println(e);
		} catch (PostIDNotRecognisedException e) {
			System.out.println(e);
		} catch (NotActionablePostException e) {
			System.out.println(e);
		}

		try {
			String showPost1 = platform.showIndividualPost(0);
			System.out.println((showPost1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println(e);
		}

		try {
			StringBuilder showPostChildrenDetails1 = platform.showPostChildrenDetails(0);
			System.out.println((showPostChildrenDetails1));
		} catch (PostIDNotRecognisedException e) {
			System.out.println(e);
		} catch (NotActionablePostException e) {
			System.out.println(e);
		}

	}
	*/

	/**
	 * Method that generates an instance of the socialmedia platform with accounts, posts, comments and endorsements
	 */
	public SocialMedia GeneratePlatform() {
		SocialMedia platform = new SocialMedia();

		assert (platform.getNumberOfAccounts() == 0) : "Initial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Initial SocialMediaPlatform not empty as required.";

		try {
			int id_1 = platform.createAccount("User1", "User1's Description");
			int id_2 = platform.createAccount("User2", "User2's Description");
			int id_3 = platform.createAccount("User3", "User3's Description");
			int id_4 = platform.createAccount("User4", "User4's Description");
			int id_5 = platform.createAccount("User5", "User5's Description");
			int id_6 = platform.createAccount("User6", "User6's Description");
			int id_7 = platform.createAccount("User7", "User7's Description");
			int id_8 = platform.createAccount("User8", "User8's Description");
			int id_9 = platform.createAccount("User9", "User9's Description");
		} catch (InvalidHandleException | IllegalHandleException e) {
			System.out.println(e);
		}

		assert (platform.getNumberOfAccounts() == 9) : "Number of accounts registered on the platform does not equal 9.";

		try {
			for (int i = 1; i < 10; i++) {
				platform.createPost("User" + i, "This is my first ever post!");
			}

			assert (platform.getTotalOriginalPosts() == 9) : "Number of original posts on the platform does not equal 9. Actual number of posts: " + platform.getTotalOriginalPosts();

			for (int i = 1; i < 10; i++) {
				platform.commentPost("User" + i, 0, "This is my first ever comment!");
			}

			for (int i = 1; i < 10; i *= 2) {
				platform.commentPost("User" + i, 9, "This is my first ever comment on another comment!");
			}

			int n = 18;
			for (int i = 1; i < 10; i *= 3) {
				platform.commentPost("User" + i, n++, "This is my first ever comment on another comment on another comment!");
			}

			assert (platform.getTotalCommentPosts() == 16) : "Number of comments on the platform does not equal 16. Actual number of comments: " + platform.getTotalCommentPosts();

			for (int i = 1; i < 10; i++) {
				platform.endorsePost("User" + i, i);
			}
			assert (platform.getTotalEndorsmentPosts() == 9) : "Number of endorsements on the platform does not equal 9. Actual number of endorsements: " + platform.getTotalEndorsmentPosts();

			platform.savePlatform("GeneratePlatformSave.ser");
		} catch (HandleNotRecognisedException | InvalidPostException | NotActionablePostException | PostIDNotRecognisedException | AssertionError | IOException e) {
			System.out.println(e);
		}

		return platform;
	}

	/**
	 * Method that shows the main menu options
	 */
	public void showMainMenu() {
		System.out.println("""
                Choose an option:
                    1: Account options
                    2: Post options
                    3: Platform options
                    4: Platform statistics
                    -1: Exit social media platform
                """);
	}

	/**
	 * Method that shows the account menu options
	 */
	public void showAccountMenu() {
		System.out.println("""
                Choose an option:
                    1: Create an account
                    2: Remove an account by handle
                    3: Remove an account by id
                    4: Change account handle
                    5: Update account description
                    6: Show account information
                    -1: Return to main menu
                """);
	}

	/**
	 * Method that shows the post menu options
	 */
	public void showPostMenu() {
		System.out.println("""
                Choose an option:
                    1: Create a post
                    2: Delete a post
                    3: Endorse a post
                    4: Comment on a post
                    5: Show a post
                    6: Show a post thread
                    -1: Return to main menu
                """);
	}

	/**
	 * Method that shows the platform menu options
	 */
	public void showPlatformMenu() {
		System.out.println("""
                Choose an option:
                    1: Save the platform
                    2: Erase the platform
                    3: Load a platform
                    -1: Return to main menu
                """);
	}

	/**
	 * Method that shows the statistics menu options
	 */
	public void showStatisticsMenu() {
		System.out.println("""
                Choose an option:
                    1: View number of accounts
                    2: View number of original posts
                    3: View number of endorsement posts
                    4: View number of comments
                    5: Get ID of most endorsed post
                    6: Get ID of most endorsed account
                    -1: Return to main menu
                """);
	}

	public void handleAccountMenu(SocialMedia platform) {
		Boolean breakLoop = true;
		do {
			System.out.println();
			showAccountMenu();
			Scanner option = new Scanner(System.in);
			String input = option.nextLine();

			if (input.equals("-1")) {
				System.out.println();
				showMainMenu();
				breakLoop = false;
			} else if (input.equals("1")) {
				System.out.println("Enter a name for the new account: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				System.out.println("Enter a description for the new account: ");
				Scanner descriptionInput = new Scanner(System.in);
				String description = descriptionInput.nextLine();
				try {
					platform.createAccount(handle, description);
					System.out.println("Account created:");
					System.out.println(platform.showAccount(handle));
				} catch (IllegalHandleException | InvalidHandleException | HandleNotRecognisedException e) {
					System.out.println(e);
				}
			} else if (input.equals("2")) {
				System.out.println("Enter the name of the account to remove: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				try {
					platform.removeAccount(handle);
					System.out.println("Account removed.");
				} catch (HandleNotRecognisedException e) {
					System.out.println(e);
				}
			} else if (input.equals("3")) {
				System.out.println("Enter the id of the account to remove: ");
				Scanner idInput = new Scanner(System.in);
				String id = idInput.nextLine();
				try {
					int accountId = Integer.parseInt(id);
					platform.removeAccount(accountId);
					System.out.println("Account removed.");
				} catch (AccountIDNotRecognisedException | NumberFormatException e) {
					System.out.println(e);
				}
			} else if (input.equals("4")) {
				System.out.println("Enter the name of the account to update the handle for: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				System.out.println("Enter a new name for this account: ");
				Scanner newHandleInput = new Scanner(System.in);
				String newHandle = newHandleInput.nextLine();
				try {
					platform.changeAccountHandle(handle, newHandle);
					System.out.println("Account handle updated.");
				} catch (IllegalHandleException | InvalidHandleException | HandleNotRecognisedException e) {
					System.out.println(e);
				}
			} else if (input.equals("5")) {
				System.out.println("Enter the name of the account to update the description for: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				System.out.println("Enter a new description for this account: ");
				Scanner newDescriptionInput = new Scanner(System.in);
				String newDescription = newDescriptionInput.nextLine();
				try {
					platform.updateAccountDescription(handle, newDescription);
					System.out.println("Account description updated.");
				} catch (HandleNotRecognisedException e) {
					System.out.println(e);
				}
			} else if (input.equals("6")) {
				System.out.println("Enter the name of the account to show information for: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				try {
					System.out.println(platform.showAccount(handle));
				} catch (HandleNotRecognisedException e) {
					System.out.println(e);
				}
			} else {
				System.out.println("Invalid input.");
			}
		} while(breakLoop);
	}

	public void handlePostMenu(SocialMedia platform) {
		Boolean breakLoop = true;
		do {
			System.out.println();
			showPostMenu();
			Scanner option = new Scanner(System.in);
			String input = option.nextLine();

			if (input.equals("-1")) {
				System.out.println();
				showMainMenu();
				breakLoop = false;
			} else if (input.equals("1")) {
				System.out.println("Enter a name of the account to post with: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				System.out.println("Enter the post text: ");
				Scanner postInput = new Scanner(System.in);
				String post = postInput.nextLine();
				try {
					int postId = platform.createPost(handle, post);
					System.out.println("Post created:");
					System.out.println(platform.showIndividualPost(postId));
				} catch (HandleNotRecognisedException | InvalidPostException | PostIDNotRecognisedException e) {
					System.out.println(e);
				}
			} else if (input.equals("2")) {
				System.out.println("Enter the ID of the post to delete: ");
				Scanner postInput = new Scanner(System.in);
				String post = postInput.nextLine();
				try {
					int postId = Integer.parseInt(post);
					platform.deletePost(postId);
					System.out.println("Post deleted.");
				} catch (PostIDNotRecognisedException | NumberFormatException e) {
					System.out.println(e);
				}
			} else if (input.equals("3")) {
				System.out.println("Enter the name of the account that is endorsing the post: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				System.out.println("Enter the ID of the post to endorse: ");
				Scanner postInput = new Scanner(System.in);
				String post = postInput.nextLine();
				try {
					int postId = Integer.parseInt(post);
					postId = platform.endorsePost(handle, postId);
					System.out.println("Post endorsed:");
					System.out.println(platform.showIndividualPost(postId));
				} catch (HandleNotRecognisedException | PostIDNotRecognisedException | NotActionablePostException | NumberFormatException e) {
					System.out.println(e);
				}
			} else if (input.equals("4")) {
				System.out.println("Enter the name of the account to comment with: ");
				Scanner handleInput = new Scanner(System.in);
				String handle = handleInput.nextLine();
				System.out.println("Enter the ID of the post to comment on: ");
				Scanner postInput = new Scanner(System.in);
				String post = postInput.nextLine();
				System.out.println("Enter the comment text: ");
				Scanner commentInput = new Scanner(System.in);
				String comment = commentInput.nextLine();
				try {
					int postId = Integer.parseInt(post);
					postId = platform.commentPost(handle, postId, comment);
					System.out.println("Comment posted:");
					System.out.println(platform.showIndividualPost(postId));
				} catch (HandleNotRecognisedException | PostIDNotRecognisedException | NotActionablePostException | InvalidPostException | NumberFormatException e) {
					System.out.println(e);
				}
			} else if (input.equals("5")) {
				System.out.println("Enter the ID of the post to show: ");
				Scanner postInput = new Scanner(System.in);
				String post = postInput.nextLine();
				try {
					int postId = Integer.parseInt(post);
					System.out.println(platform.showIndividualPost(postId));
				} catch (PostIDNotRecognisedException e) {
					System.out.println(e);
				}
			} else if (input.equals("6")) {
				System.out.println("Enter the ID of the post thread to show: ");
				Scanner postInput = new Scanner(System.in);
				String post = postInput.nextLine();
				try {
					int postId = Integer.parseInt(post);
					System.out.println(platform.showPostChildrenDetails(postId));
				} catch (PostIDNotRecognisedException | NotActionablePostException | NumberFormatException e) {
					System.out.println(e);
				}
			} else {
				System.out.println("Invalid input.");
			}
		} while(breakLoop);
	}

	public void handlePlatformMenu(SocialMedia platform) {
		Boolean breakLoop = true;
		do {
			System.out.println();
			showPlatformMenu();
			Scanner option = new Scanner(System.in);
			String input = option.nextLine();

			if (input.equals("-1")) {
				System.out.println();
				showMainMenu();
				breakLoop = false;
			} else if (input.equals("1")) {
				System.out.println("Enter the filename to save the platform as: ");
				Scanner filenameInput = new Scanner(System.in);
				String filename = filenameInput.nextLine();
				try {
					platform.savePlatform(filename);
					System.out.println("Platform saved.");
				} catch (IOException e) {
					System.out.println(e);
				}
			} else if (input.equals("2")) {
				platform.erasePlatform();
				System.out.println("Platform erased.");
			} else if (input.equals("3")) {
				System.out.println("Enter the filename of the platform to load: ");
				Scanner filenameInput = new Scanner(System.in);
				String filename = filenameInput.nextLine();
				try {
					platform.loadPlatform(filename);
					System.out.println("Platform loaded.");
				} catch (IOException | ClassNotFoundException e) {
					System.out.println(e);
				}
			} else {
				System.out.println("Invalid input.");
			}
		} while(breakLoop);
	}

	public void handleStatisticsMenu(SocialMedia platform) {
		Boolean breakLoop = true;
		do {
			System.out.println();
			showStatisticsMenu();
			Scanner option = new Scanner(System.in);
			String input = option.nextLine();

			if (input.equals("-1")) {
				System.out.println();
				showMainMenu();
				breakLoop = false;
			} else if (input.equals("1")) {
				System.out.println(platform.getNumberOfAccounts());
			} else if (input.equals("2")) {
				System.out.println(platform.getTotalOriginalPosts());
			} else if (input.equals("3")) {
				System.out.println(platform.getTotalEndorsmentPosts());
			} else if (input.equals("4")) {
				System.out.println(platform.getTotalCommentPosts());
			} else if (input.equals("5")) {
				System.out.println(platform.getMostEndorsedPost());
			} else if (input.equals("6")) {
				System.out.println(platform.getMostEndorsedAccount());
			} else {
				System.out.println("Invalid input.");
			}
		} while(breakLoop);
	}

	/**
	 * Method that runs the socialmedia platform from the command line
	 */
	public void socialMediaTerminalProgram(SocialMedia platform) {
		if (platform == null) {
			platform = new SocialMedia();
		}

		showMainMenu();

		do {
			Scanner option = new Scanner(System.in);
			String input = option.nextLine();
			if (input.equals("-1")) {
				System.exit(-1);
			} else if (input.equals("1")) {
				handleAccountMenu(platform);

			} else if (input.equals("2")) {
				handlePostMenu(platform);

			} else if (input.equals("3")) {
				handlePlatformMenu(platform);

			} else if(input.equals("4")){
				handleStatisticsMenu(platform);

			} else {
				System.out.println("Invalid input.");
				System.out.println();
			}
		} while (true);
	}

	public static void main(String[] args) {
		System.out.println("----------------------- Social Media Platform ----------------------- ");
		System.out.println("""
                Choose an option:
                   1: Create, save and load an instance of the socialmedia platform with accounts, posts, comments and endorsements.
                   2: Load an instance of the socialmedia platform from a file. 
                   3: Create a new instance of the socialmedia platform.""");

		Scanner option = new Scanner(System.in);
		String input = option.nextLine();

		if (input.equals("1")) {
			SocialMediaPlatformTestApp socialMediaTest = new SocialMediaPlatformTestApp();
			SocialMedia platform = socialMediaTest.GeneratePlatform();
			socialMediaTest.socialMediaTerminalProgram(platform);
		} else if (input.equals("2")) {
			System.out.println("Enter the filename of the platform to load: ");
			Scanner filenameInput = new Scanner(System.in);
			String filename = filenameInput.nextLine();
			SocialMedia platform = new SocialMedia();
			try {
				platform.loadPlatform(filename);
				System.out.println("Platform loaded.");
				SocialMediaPlatformTestApp socialMediaTest = new SocialMediaPlatformTestApp();
				socialMediaTest.socialMediaTerminalProgram(platform);
			} catch (IOException | ClassNotFoundException e) {
				System.out.println(e);
			}
		} else if (input.equals("3")) {
			SocialMediaPlatformTestApp socialMediaTest = new SocialMediaPlatformTestApp();
			socialMediaTest.socialMediaTerminalProgram(null);
		} else {
			System.out.println("Invalid input.");
			System.out.println();
			main(null);
		}
	}

}
