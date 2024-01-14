// init-mongo.js
db.createUser({
  user: "usuario",
  pwd: "contraseña",
  roles: ["readWrite", "dbAdmin"]
});

db = db.getSiblingDB("Ix-EV-DBO");

db.createCollection("Products");

db.Products.insert({
  "id": 1,
  "name": "V-NECH BASIC SHIRT",
  "sales_units": 100,
  "stock": {
    "S": 4,
    "M": 9,
    "L": 0
  }
});

db.Products.insert({
  "id": 2,
      "name": "CONTRASTING FABRIC T-SHIRT",
      "sales_units": 50,
      "stock": {
        "S": 35,
        "M": 9,
        "L": 9
      }
});

db.Products.insert({
  "id": 3,
      "name": "RAISED PRINT T-SHIRT",
      "sales_units": 80,
      "stock": {
        "S": 20,
        "M": 2,
        "L": 20
      }
});

db.Products.insert({
  "id": 4,
      "name": "PLEATED T-SHIRT",
      "sales_units": 3,
      "stock": {
        "S": 25,
        "M": 30,
        "L": 10
      }
});

db.Products.insert({
  "id": 5,
      "name": "CONTRASTING LACE T-SHIRT",
      "sales_units": 650,
      "stock": {
        "S": 0,
        "M": 1,
        "L": 0
      }
});

db.Products.insert({
  "id": 6,
      "name": "SLOGAN T-SHIRT",
      "sales_units": 20,
      "stock": {
        "S": 9,
        "M": 2,
        "L": 5
      }
});