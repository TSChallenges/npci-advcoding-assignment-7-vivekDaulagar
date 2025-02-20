# Store Management System API
## Advanced Coding Assignment-7

### Problem Statement
You are tasked with creating a RESTful web service for a **Store Management System** using Spring Boot. The API will allow users to manage products, including adding, updating, deleting, and retrieving products. Additionally, the system should support search and filter operations to allow users to efficiently find products based on various criteria (e.g., name, category, price range, stock quantity range). The system will store product data in an in-memory data structure (e.g., `List`) for simplicity.

### Steps to Follow
1. This GitHub repository will be accessible to you once you accept the Assignment.
2. You have to work directly in this GitHub repository. It is like your own copy of the original repository.

3. The folder structure is as given below: (showing major files only)
   ```
   root
   ├── pom.xml
   └── src/main
       ├── java/com/mystore/app
       |   ├── entity
       |   |   └── Product.java
       |   ├── rest
       |   |   └── ProductController.java
       |   ├── service
       |   |   └── ProductService.java
       |   └── AppApplication.java
       └── resources
           ├── static
           |   └── index.html
           └── application.properties
   ```

4. Review the code/comments present in above files to understand the structure.
5. Implement the missing classes/methods marked with **TODO** comments.
6. To work on the files, you can clone this GitHub repository onto your system and then open it with an IDE like IntelliJ, or Eclipse.
7. Once done, push your changes to this remote GitHub repository.

### Files to Work On
- `src/main/resources/static/index.html`
- `src/main/java/com/mystore/app/entity/Product.java`
- `src/main/java/com/mystore/app/service/ProductService.java`
- `src/main/java/com/mystore/app/rest/ProductController.java`

### Starter Code Files:
Starter code for below functionalities have already provided:
1. **Spring Boot application:**
   - Use Spring Boot to set up the application.
   - Use `Spring Web` dependency to create the RESTful APIs.
   - Implement in-memory storage for bank accounts using a `List`.

2. **Product Entity:**
   A `Product` class is already provided with the following fields:
   - `id` (Integer, Unique Identifier for the Product)
   - `name` (String, Not Null)
   - `category` (String, Not Null, e.g., "Electronics", "Clothing", etc.)
   - `price` (Double, Not Null, must be a positive value)
   - `stockQuantity` (Integer, Not Null, must be a non-negative value)

3. **REST Endpoints:** Implementation provided for the following REST endpoints for managing the products:
   - **Create a new product:** `POST /products`
     - Request Body: JSON object with fields `name`, `category`, `price` and `stockQuantity`.
     - Response: JSON object with the newly created product details, including the generated `id`.
   - **Get all products:** `GET /products`
     - Response: A list of all products in JSON format.
   - **Get a product by ID:** `GET /products/{id}`
     - Response: A JSON object of a single product, or `404 Not Found` if the product doesn't exist.
   - **Update product details:** `PUT /products/{id}`
     - Request Body: JSON object with updated fields `name`, `category`, `price`, `stockQuantity`.
     - Response: The updated product details, or `404 Not Found` if the product doesn't exist.
   - **Delete a product:** `DELETE /products/{id}`
     - Response: `204 No Content` if the product is deleted successfully, or `404 Not Found` if the product doesn't exist.


## Requirements:
1. **Root endpoint** `http://localhost:9000`
   
   Update the `index.html` file to render the heading `Store Management System API`
2. **Search and Filter Products:** Implement search and filter endpoints to allow users to find products based on various criteria:
   - **Search products by name:** `GET /products/search`
     - Query Parameters:
       - `name`: The name of the product to search for (e.g., `name=phone`).
     - Response: A list of products that match the search term in the name field (case-insensitive).
   - **Filter products by category:** `GET /products/filter/category`
     - Query Parameters:
       - `category`: The category to filter products by (e.g., `category=Electronics`).
     - Response: A list of products that belong to the specified category.
   - **Filter products by price range:** `GET /products/filter/price`
     - Query Parameters:
       - `minPrice`: The minimum price (e.g., `minPrice=10`).
       - `maxPrice`: The maximum price (e.g., `maxPrice=100`).
     - Response: A list of products whose price falls within the specified range.
   - **Filter products by stock quantity:** `GET /products/filter/stock`
     - Query Parameters:
       - `minStock`: The minimum stock quantity (e.g., `minStock=10`).
       - `maxStock`: The maximum stock quantity (e.g., `maxStock=100`).
     - Response: A list of products whose stock quantity is within the specified range.
3. **Run the application on port 9000**

   Update the `application.properties` file to run the application on port `9000` instead of the default port `8080`

## Submission Requirements:
Implement the required API endpoints for the provided Spring Boot application. You can use Postman or cURL commands to test your API endpoints.

After completing the challenge and developing the solution code in your system, commit and push the changes to this repository. 
  - Stage your changes and commit the files:
    ```
    git add .
    git commit -m "Completed playground challenge"
    ```
  - Push your changes to the GitHub repository:
    ```
    git push
    ```

## Grading Criteria:
- To run the application on port `9000` instead of default port `8080` [1 Mark]
- To render the index.html page correctly at `http://localhost:9000` [1 Mark]
- To implement search endpoint correctly [2 Marks]
- To implement filter by category endpoint correctly [2 Marks]
- To implement filter by price endpoint correctly [2 Marks]
- To implement filter by stock quantity endpoint correctly [2 Marks]

Good luck, and happy coding!
