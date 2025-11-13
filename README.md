# 🦀 The Chummy Krab POS System 🍔
*A SpongeBob-inspired Point of Sale Java Application*

Welcome to **The Chummy Krab**, a fun **SpongeBob Krusty Krab × Chum Bucket** themed Point of Sale (POS) system!  
This project was built as a **Capstone Java application** that demonstrates **Object-Oriented Programming (OOP)** principles, **file I/O**, and **interactive console menus** for a fully functioning restaurant order management system.

---

## 🧾 Project Overview

The **Chummy Krab POS System** automates the process of taking customer orders — no more messy paper tickets! Customers can build and customize their orders, add sides or drinks, and even edit or remove items before checkout. Once confirmed, their order is saved as a timestamped receipt file.

This application highlights **OOP design**, **enums**, and **data persistence** through text receipts.

---

## 🍔 Theme

Inspired by the underwater rivalry between the **Krusty Krab** and the **Chum Bucket**, the restaurant is a mashup called **The Chummy Krab** — serving Krabby-style burgers with Plankton’s “special” touch.

Customers can build their perfect burger by choosing:
- **Size** Chummy Patty jr.(Small),Chummy Patty(Medium),King Neptunes Chummy Patty(Large)
- **Bun Type** (Potato, Kelp, None)
- **Patty Type** (Krabby Patty, Chum Patty, Veggie Patty)
- **Regular & Premium Toppings**
- **Special Option** (Make it a meal)

---

## ⚙️ Application Features

### 🏠 Home Screen
- `1) New Order` – Start a new customer order
- `0) Exit` – Exit the application

### 🍟 Order Screen
- `1) Add Item` – Build and customize a burger
- `2) Add Drink` – Choose drink size and flavor
- `3) Add Side` – Add fries, chum sticks, or other sides and size
- `4) Signature Meal` – Choose from options of signature meals
- `5) Checkout` – Review and confirm the order
- `0) Cancel Order` – Cancel the order and return home

### 🍔 Add Item Flow
- Choose **Size, Bun, Patty**
- Add **Toppings** (Regular or Premium)
- Option to add **Extras** or make it a **Combo**
- View item summary before saving

### 🧃 Add Drink
- Select **Drink Size** (Small, Medium, Large)
- Choose **Flavor**

### 🍟 Add Side
- Choose from available sides

### 🍔 Signature Meal
- Choose between the preset **Pretty Patty Signature Meal** or **Nasty Patty Signature Meal**

### 💵 Checkout
- Displays full order summary and total price
- Option to **Edit** or **Remove Items** before finalizing
- Confirm to **Save Receipt** as a text file
    - Receipt is saved in `/receipts/` folder
    - Filename format: `yyyyMMdd-hhmmss.txt`

---

## 🧠 OOP Concepts Used

- **Encapsulation** – Each menu item, topping, and order are represented by distinct classes.
- **Inheritance & Polymorphism** – Shared behavior among menu items through base and subclass structures.
- **Enums** – Used for `Size`, `BunType`, and `PattyType` to ensure type safety and cleaner code.
- **Composition** – Orders are composed of multiple item objects.
- **Abstraction** – Interfaces and abstract classes to generalize shared behavior.

---

## 💻 Technologies Used

- **Language:** Java
- **Paradigm:** Object-Oriented Programming
- **IDE:** IntelliJ IDEA 
- **Data Storage:** Local text files (for receipts)