# App Plan
## App Description
1.	Developer name: 
Lucian Petrus 2007281
2. Title: 
The Recipe App
3.	Promo text: 
Discover your next meal, learn to cook it and enjoy an explosion of flavors
4.	Description:
There’s always been at least one night/ week when everyone wonders what they should cook. This is where The Recipe App comes into play. The app aims to allow users to search for different recipes for inspiration, see a list of essential pantry ingredients and also provide them with an updated list of useful kitchenware. The apps’s theme is mainly white with bright green accents, which give it a refreshing sensation. The app uses 4 interlinking pages, which can be accessed based on Log In status of the user. The user credentials are stored in a cache SQLlite database. <br> <br> The main features of The Recipe App are:
*	In order to allow users to search for recipes, the app uses a TheMealDB API feature, which displays search results in a simple, clean, user-friendly manner.
*	 To get to the part where one can search for recipes, a user must create or sign into their account, which can be done on the starting page of the app. 
*	However, to simply see a list of pantry essentials logging in is not necessary, as users can simply access the page displaying information about different ingredients, cans, types of beans etc., from the starting page.
*	A user doesn’t have to be signed in to see a list of recommended kitchenware, as well. This list includes information about types of knives, cutlery, pans and so on.
## App Design
When first starting the application, the user will be taken to the main page, which is the login page.
<br>
![My Image](https://github.com/WorkAtRGU/cm3110-coursework-xluciusx5/blob/master/readmePictures/pic1.PNG)
<br>
In the middle of the screen rests the app’s logo, which has been displayed using an ImageView. Right below the logo, there are 2 EditTexts which enable the user to type in their desired/ actual username and password in order to register or sign in, respectively. The last 2 processes are actionized using the 2 Buttons displayed at the bottom of the page. This system was developed using an SQLlite database, using cache resources, i.e. whenever the application is closed, all data will be gone. The data taken is composed of 2 individual strings of text, which form the two table columns (username and password).
<br>
The top of the page contains 2 more Buttons, each leading to a different page (Kitchenware and Pantry Essentials). When tapping the “See Tools” button, the user will be taken to this page.
<br>
![My Image](https://github.com/WorkAtRGU/cm3110-coursework-xluciusx5/blob/master/readmePictures/pic2.PNG)
<br>
This page is particularly simple, as it contains an ImageView displaying an assortment of kitchenware, a TextView which contains a list of these tools and a Button which can pe tapped to get back to the Main Page. The action performed by the button revolves around a typical onClickListener method and an intent method.
<br>
The same applies for the Pantry Essentials page, as it’s the same wireframe/ design and uses the same widgets and mostly the same code, changed where relevant (i.e., button methods).
<br>
![My Image](https://github.com/WorkAtRGU/cm3110-coursework-xluciusx5/blob/master/readmePictures/pic3.PNG)
<br>
After creating or signing into an account, the users will be taken to the page where they can search for recipes. The search feature has been implemented to get data with The Meal DB API. The collected data involves the meal name, category, area, instructions, thumbnail and tags.
<br>
![My Image](https://github.com/WorkAtRGU/cm3110-coursework-xluciusx5/blob/master/readmePictures/pic4.PNG)
<br>
This page concentrates on the ListView, which will display the search results based on the text inputted by the user in the EditText box (search bar) at the top of the page and actionizing the search mechanism by tapping the Search Button i.e., start the API. To display recipes, a view holder was developed, setting the tone of display for all search results (either 1 or multiple).
<br>
![My Image](https://github.com/WorkAtRGU/cm3110-coursework-xluciusx5/blob/master/readmePictures/pic5.PNG)
<br>
The recipe’s view holder contains a Card View which allows a neat presentation of all search results, either one or multiple. This widget contains an ImageView (the thumbnail fetched by the API is fed into this widget) and two TextViews which display the recipe’s title (again, fetched by the API) and description (all other data fetched by the API). <br> 
The app’s Log In system also has the expected functionality. For example, if an already existing user tries to create a new account with the same username, an error message will appear. There is also the case when a user tries to continue to the Search Page without logging in, which is not possible. Accessing the other 2 pages (Kitchenware and Pantry essentials) is not conditioned on the status of the log in system.
<br>
<br>
## Reflective Statement
The most important part of the app is the API it’s using. In retrospective, I should have done more research before choosing my app, since finding a good API to fetch meal data proved to be rather difficult and time consuming, as multiple trial and error attempts have been involved in the process of building the app, using different APIs which could either be partially implemented or complete failures. As it was my first time using an SQLlite cache database, I was intrigued by the process of creating a database using Java in Android Studio, rather than MySQL in SQL Server. If a log in system could have been developed (and marked) using  Firebase, perhaps that’s what I would have chosen, as I find it more accessible. In terms of future projects involving Android apps, I also believe using a navigation graph would prove to be less time consuming and more appropriate, enabling other developers reviewing or continuing your work to make this process less complicated.
<br>
<br>
<br>
Relevant app tests can be found here
https://github.com/WorkAtRGU/cm3110-coursework-xluciusx5/blob/master/readmePictures/recipe%20app%20tests.pdf

