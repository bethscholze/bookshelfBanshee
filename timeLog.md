|Date|Time(hrs)|What|How/Outcome|
|----|---------|----|-----------|
|1/24|1|vm setup|tried setting up vm on portable ssd, it was taking forever to load in so I shut down the process|
|1/25|1|vm setup/exercise 1 setup|moved vm to the desktop and it booted up right away, pulled down the first assignment from github and got it up and running|
|1/27|2.5|catch up on week 1 readings/videos|Things to remember: maven intellij stuff, install jdoc, refactor extract method, generate, local history|
|1/27|2|week 2 readings|commit messages ###if applied this commit will. Didn't have access to the student repo, willl have to work on those activities for next class|
|1/29|2.5|week 2 activities and exercise setup|got access to the student repository, did activities, and setup indie project. Remember to git pull before pushing to any student repo. #todo figure out profDevPresentation topic and sign up for timeslot|
|1/29|2|Started week 2 exercise|sql error, had to change table name from user to users. Vm crash, changed settings to 2 processors.https://stackoverflow.com/questions/29750861/convert-between-localdate-and-sql-date  https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html#now--|
|2/1|1|worked on week 2 exercise|setup search.jsp and changed teh servlet to forward to it|
|2/2|2|Finished week 2 exercise|got the search query to be passed to call into the database, had trouble with the prepared statements formatting(you cannot put the column name in a prepared statement, which makes sense now), prettied up the form and table for output|
|2/3|5|Started week 3|Read docs(notes on junit tests in documents), and watched videos for week 3(except Puzzle-solving), worked through activities. Started exercise. Forgot to take screenshots of weeks 2 work|
|2/5|5|Worked on week 3 exercise, wrote most user stories|Wrote tests, had trouble with exception test, doesnt return a caught exception, just check for null/zero value|
|2/8|2.5|Presentation feedback, working on project|work on wireframe, database design, and revisit user stories|
|2/9|2.5|Project design|Problem statement, project plan.|
|2/10|5|Finalize exercise 3. Project design|All test passing for exercise 3, click on the run on the left side and it will provide test coverage. Update stuff more tonight since you for got the list you made. Work on wireframes.|
|2/12|5|Week 4 videos and exercise|Caught up on week 4 videos and started the week 4 exercise. Remember to colpy the config file to the test directory to get mysql test db to work.|
|2/16|3|Week 4 exercise|Got week 4 exercise almost done, need to get the rest of the tests working. MYSQL DATADUMP= mysqldump -u root -p BookshelfBansheeTest > BookshelfBansheeTest_backup.sql|
|2/17|7|Week 4 exercise and project jsps|Finished the week 4 exercise and worked on jsps. Watched some week 5 videos.|
|2/18|1|Week 5 videos|Finished week 5 videos.|
|2/19|5|Week 5 work|Created book class and added book table to database|
|2/22|4|Project work|Worked on html pages for my project, need to paste the hmtl into my current jsps|
|2/23|4|Week 5 daotests|writing and debuggin why tests weren't passing. Put user and book in toString creating a stackoverflow. Don't do that|
|2/24|3|Week 6|In class code reviews/discussions. Read a little on aws for the week|
|2/26|3|Week 6|Got my account id to send to Paula. Code reviewed Elspeth's project.|
|2/26|2|Week 6|Code review Anthony's project. Planning some methods for my project.|
|3/1|4|Week 6|setup aws, videos|
|3/2|3|Week 6-7|Working on checkpoint 2, erd and class diagrams|
|3/4|5|Week 7|implemented login, worked on professional development presentation|
|3/8|3|Professional Dev|added links to materials for presentation|
|3/9|1|Week 5 testing|Fixed mysql daylight savings error, updated my tests for the one to many to test the outcome of deletes.|
|3/11|5|prof dev presentation prep|researched a bunch of stuff for presentation planned out analyzer|
|3/13|5|prof dev presentation|finished up presentation|
|3/16|6|bookshelf banshee|updated my database design and entities for it|
|3/17|6|bookshelf banshee|working on entity relationships in my project and dao testing for my entities|
|3/22|3|week 8 rest|Got the call to the rest client working but could not get pojo generation working|
|3/23|3|week 8 Rest|Got pojo generator working(used older version) and got the tests running, errors occur if client isn't created in TEST class, have to add an additional dependency that has the scope of tests|
|3/24|3|Checkpoint 3|Finally got my app working on aws with authentication, I did not configure the realm properly for the db in the server.xml file (tomee manager goes in tomcat-user.xml)|
|3/25|4|Group project|worked on jsps|
|3/30|3|Week 9|read up on jersey stuff, and implemented a service in my indie project to return the users|
|3/30|3|Week 9|worked on branching and merge requests|
|3/31|4|Week 9|Fixing json data returns, needed json properties in the constructor for user and json ignore for the hibernate relationships. Need to look in to lazy loading for hibernate relationships|
|3/31|1|Week 9|loading user lists to the homepage.|
|4/1-4/5|6|Week 10|Spent time figuring out how my books.jsp page was going to work for editing books and adding books|
|4/6|4|Week 10|Helped matt look at stuff to hide api keys|
|4/8|6|Team project|entity workflow diagram|
|4/20-4/23|Indie project|15|Did work on book details, spent a lot of time figuring out where I was and how I could accomplish what I need to by presentation day. Decided to do servlets instead of javascript for the book details because it was too complicated to figure out how to convert java object in session to js object in order to display things on the page and then save the modified version of the object. Will come back to this if I have time at end of project since I already wasted too much time messing with it. |
|4/27|2|Week 13|Did message exercise. Gave feedback on prof dev project|
|4/27|4|Indie project work|Create signup page logic, and add later|
|4/29|6|Indie Project Work|Added the login to logout the user and delete their session. Started to work on the edit book logic. Books are now in lists so they can be passed to the next page by their number in the list and the corresponding dao can be grabbed to save edits|
|4/29|3|Week14|Reviewed anthony's project and provided feedback|
|5/1|5|Indie project work|worked on edit books functionality|
|5/3|6|Indie Project work|finished edit books functionality except for front end styling. Found and fixed a bug in my api call introduced from the edit functionality. Working on add books functionality to search google books and return result to be added to the db.|
|5/4|4|Indie Project work|completed add books functionality, completed delete books functionality as well (I think)|
|5/5-5/13|35-45|Indie project work|I forgot to keep this updated the last week....I got stuck trying to finish the lists functionality and ended up presenting without it working. As mentioned in my presentation I wanted to map the googleData to my db data for each user so I could correlate the two easier without having to iterate through set after set. This process cleaned up a lot of excess code and made it much easier to implement the lists functionality. It did lead to me having to redo my pretty sorting page to be a mess though, but that was unavoidable once it had to sort through maps instead of lists. Eventually I would like to serialize the map data to pass it around, but I don't have time for that right now. |