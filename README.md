# A Spring Boot-based blog application that allows users to post, edit, comment on blogs, and bookmark their favorite posts.

## Features
📝 Create, edit, and delete blog posts
💬 Comment on blog posts
🔖 Bookmark blogs for easy access
📡 RESTful API architecture
📊 Scalable backend using Spring Boot and MVC
## Technologies Used
- Spring Boot – Backend framework
- Spring Data JPA – Database management
- MySQL/PostgreSQL – Database
- Spring Security – Authentication & Authorization(JWT)

## Installation & Setup:
1. Clone the repository
  git clone https://github.com/your-username/blog-app.git
  cd blog-app
2. Configure apploication.yml file
   datasource:
    password: root
    url: jdbc:mysql://localhost:3306/blogdb
    username: your_password
3. Build and run:
     mvn spring-boot:run


## API Endpoints: 
# Blog API's
  To add a blog : http://localhost:8080/add-blog (body : title, category, content)
  To edit a blog :  http://localhost:8080/edit (body: same as adding a blog)
  To delete a blog :  http://localhost:8080/delete/blogid
  To bookmark a blog :  http://localhost:8080/bookmark/userid/blogid
  To view all blogs :  http://localhost:8080/show-all
  To view blogs of specific category :  http://localhost:8080/category/category_name

# Comment API's
  To add a comment :  http://localhost:8080/comment/add/blog_id (body : userName, comment)
  To edit a comment :   http://localhost:8080/comment/edit/comment_id (body : same as adding a comment)
  To delete a comment :   http://localhost:8080/comment/delete/comment_id

# User API's
  To add a user : http://localhost:8080/register (body : userName, password)
  To login :   http://localhost:8080/login (body : userName, password)
  To get the bookmarked blogs :   http://localhost:8080/get-bookmarks/user_id

