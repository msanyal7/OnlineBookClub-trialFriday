# OnlineBookClub
Refactoring Implementations
1. Britney Wang (UserProfileController)
   - Original Issue:
     - The actionPerformed() method was bloated and tightly coupled.
     - Logic for UI and business operations was tangled together.
   - Solution
     - Extracted logic from actionPerformed() into two helper methods: openChangeSubscriptionWindow() and openAddPaymentWindow()
     - Used SwingUtilities.invokeLater() for proper UI threading
        in both helper methods.
2. Stephanie Goodie-Obi (UserProfileController)
   - Original Issue:
     - There was a lot of unused overloaded comments that were bloating and not doing anything
   - Solution
     -Cleaned up code files that had the issue.
3. Sereina Williams (AddBookForm & LibraryController)
    - Original Issue:
        - AddBookForm.java didn't have any validation handling
        - openAddForm() method in LibraryController.java awas bloated and tightly coupled
    - Solution:
        - Used SwingUtilities.involeLater() for proper UI threading
        - Implemented validation handling from the user, making sure that it doesn't allow blank inputs
4. Manali Sanyal
   - Original Issue: Issues with Meeting MVC - controller not implemented 
   - Solution: Implemented controller and confrimed button functionality 
   - Made sure GUI was functional 
   - added logic in Meeting, MeetingsList 



| Team-Member ID | Team-Member Name     | Percentage efforts           | brief of tasks                                                                                                                                                                                                                                                                                                              |
|----------------|----------------------|------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 001            | Stephanie Goodie Obi | **Observer Pattern**         | Added and configured channel list implentastion in the project file. Users can now see what channels they are a part of, remove themselves and invit other users.                                                                                                                                                           |
| mjs8580        | Manali Sanyal        |                              |                                                                                                                                                                                                                                                                                                                             |
| snw5334        | Sereina Williams     | **Observer Pattern**         | Added the rest of the CRUD operations in the library. Users can add a book, update the book details, and delete a book from the library. I also did the track progress aspect. The user can click a book in the library and update which page they are at in the book. It will then show the percentage of book completion. |  
| bqw5394        | Britney Wang         |                              |                                                                                                                                                                                                                                                                                                                             |   


Design Patterns

| Team-Member ID | Team-Member Name     | Design Pattern Implemented     | Classes / Interfaces implementing the Design Pattern                   |
|----------------|----------------------|--------------------------------|------------------------------------------------------------------------|
| 001            | Stephanie Goodie Obi | **Observer Pattern**           | `Channel`, `ChannelObserver`, `ChannelView`, `ChannelController`       |
| 001            | Stephanie Goodie Obi | **Infinte Scroll Pattern**     | `ChannelView`                                                          |
| mjs8580        | Manali Sanyal        | **Factory Pattern**            | `Meeting, MeetingsList,                                                |
| snw5334        | Sereina Williams     | **Observer Pattern**           | `ReadingProgress` , `LibraryView`, `AddBookForm` , `LibraryController` |   
| bqw5394        | Britney Wang         | **Command and Wizard Pattern** | 'UserProfileController'                                                 |   

- Subscription Management
  - Command Pattern - In SubManagement > Controller > Modify Subs, the 'deleteSub' method stores 'currentSub' variable which is inputted by the user. When the user wants calls 'deleteSub', the function calls the previous stored state and delete the Subscription.
  - Wizard Pattern - Guides the user in the subscription payment process. Here are the steps:
    1. View user profile
    2. Click “Change” button next to subscription status
    3. Click “Change to Premium” button
    4. Add payment method
       - Add first name
       - Add last name
       - Add credit card info
       - Add expiration date
    5. Click “Save & Submit” button
    6. Subscription changed and information saved message


- Track Progress
  - Observer Pattern
  - Dashboard Pattern
- Channels
  - Observer Pattern
- **Implemented in**: `Channel` (Model) and `ChannelView` (View) components  
- **Behavior**:  
  1. User enters comment text and clicks "Send" button  
  2. `ChannelController` creates new `Comment` object  
  3. `Channel` model adds comment to its collection  
  4. `Channel` notifies all registered observers (`ChannelView` instances)  
  5. Each `ChannelView` updates its UI to display the new comment  
  6. Scroll position automatically adjusts to show latest message  

  - Infinite-Scroll Pattern
    - **Implemented in**: `ChannelView` using `JScrollPane`  
- **User workflow**:  
  1. User opens channel view  
  2. Initial batch of recent comments loads  
  3. As user scrolls up:  
     - Scroll position is monitored  
     - When nearing top, older comments are fetched  
     - New comments are dynamically added to the top  
  4. Smooth scrolling maintained throughout  
  5. Loading indicators shown during data fetch  
  6. Scroll position preserved when new content loads 
- Homepage & User
  - Observer Pattern
  - Infinite Scroll Pattern
- Meetings
  - Factory Method
  - Dealing with Data Pattern

---
3/9 M02 - M03: System Component API Stubs and Automated System Tests

Ashley - Added methods stubs for the Channel Controller class

Manali- added and tested Meeting model as well as adding method stubs. 

Britney - Implemented method stubs for every method exposed in the SubManagement 
Module and User class related to subscription and payment. Added related methods
in TestHarness class to exercise those methods.

Stephanie - Created, refactored and tested functions toward implementing the Channel class

Sereina - Created, refactored and tested functions toward implementing the Track Progress, library, and reading goal classes

---
Previous Assignment

Ashley - I contributed to the channel package.

Manali - I contributed and made to the MeetingBookClub package.

Britney - I worked on both the API design and the code implementation for the Subscription Management MVC.

Stephanie - I worked on the Channel Management MVC, and all the classes contained in the code logic

Sereina - I worked on both the API design and the code implementation for the Homepage and TrackProgress MVC.

