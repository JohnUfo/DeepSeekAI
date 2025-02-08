# **DeepSeek-R1 with Ollama** 🚀  

DeepSeek-R1 is a powerful reasoning model series designed for **math, code, and logic**, delivering performance comparable to OpenAI-o1. This repository provides step-by-step instructions to **download, run, and manage DeepSeek-R1 models using Ollama**.  

## **🔧 Installation**  

### **1️⃣ Install Ollama**  
First, download and install **Ollama** from the official website:  

👉 [Download Ollama](https://ollama.com/library/deepseek-r1)  

### **2️⃣ Download the DeepSeek-R1 Model**  
After installing Ollama, open your terminal and run the following command to download a specific DeepSeek-R1 model:  

```sh
ollama pull deepseek-r1:14b
```  

You can replace `14b` with any of the available model sizes:  

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
ollama run deepseek-r1:14b
```  

Then, open your browser and go to:  

👉 **[http://localhost:8080](http://localhost:8080)**  

## **🗑️ How to Remove a Model**  
To remove a model from your system, use:  

```sh
ollama rm deepseek-r1:14b
```  
Replace `14b` with the model version you want to remove.  
