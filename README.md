# **DeepSeek-R1 with Ollama & Spring Boot** 🚀

DeepSeek-R1 is a powerful reasoning model series designed for **math, code, and logic**, delivering performance comparable to OpenAI-o1. This repository provides step-by-step instructions to **download, run, and manage DeepSeek-R1 models using Ollama** and **store chat history using PostgreSQL** in a Spring Boot application.

## **🔧 Installation**

### **1️⃣ Install Ollama**
First, download and install **Ollama** from the official website:

👉 [Download Ollama](https://ollama.com/library/deepseek-r1)

### **2️⃣ Download the DeepSeek-R1 Model**
After installing Ollama, open your terminal and run the following command to download a specific DeepSeek-R1 model:

```sh
ollama pull deepseek-r1:7b
```  

You can replace `7b` with any of the available model sizes:

```sh
# Available DeepSeek-R1 Models
ollama pull deepseek-r1:1.5b  # 1.5B model
ollama pull deepseek-r1:7b    # 7B model
ollama pull deepseek-r1:8b    # 8B model
ollama pull deepseek-r1:14b   # 14B model
ollama pull deepseek-r1:32b   # 32B model
ollama pull deepseek-r1:70b   # 70B model
```

### **3️⃣ Run the Model**
Once downloaded, you can start using the model with:

```sh
ollama run deepseek-r1:7b
```  

Then, open your browser and go to:

👉 **[http://localhost:8080](http://localhost:8080)**

## **💾 Setting Up PostgreSQL for Chat Storage**
To store previous chat interactions, you need to **set up a PostgreSQL database**.

### **1️⃣ Install PostgreSQL**
If you don’t have PostgreSQL installed, install it using:

**For Debian/Ubuntu:**
```sh
sudo apt update && sudo apt install postgresql postgresql-contrib
```  

**For macOS (Homebrew):**
```sh
brew install postgresql
brew services start postgresql
```  

**For Windows:**  
Download and install PostgreSQL from: 👉 [https://www.postgresql.org/download/](https://www.postgresql.org/download/)

### **2️⃣ Update Spring Boot Configuration**
In the `application.properties` file, update the **PostgreSQL database connection details** according to your setup:

```properties
# Ollama Model Configuration
spring.ai.ollama.chat.options.model=deepseek-r1:7b

# PostgreSQL Database Configuration (Modify these based on your database settings)
spring.datasource.url=jdbc:postgresql://localhost:5432/deepseek
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate & JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.show-sql=true
```

**⚠️ Important:**
- Replace `your_username` and `your_password` with your PostgreSQL credentials.
- Ensure that the database name in `spring.datasource.url` matches your PostgreSQL setup.
- The project **automatically creates tables**, so you **don’t need to manually create entities or tables**.

## **🗑️ How to Remove a Model**
To remove a model from your system, use:

```sh
ollama rm deepseek-r1:7b
```  
Replace `7b` with the model version you want to remove.  
