// dbdiagram.io code to generate database diagram

Table bookstore.author {
  author_id int [pk]
  first_name varchar
  last_name varchar
  street varchar
  city varchar
  state char
  postal_code varchar
  phone varchar
  email varchar
}

Table bookstore.book {
  book_id int [pk]
  isbn varchar
  publish_date date
  author_id int
  title varchar
  publisher_id int
  price decimal
}

Table bookstore.publisher {
  publisher_id int [pk]
  name varchar
  street varchar
  city varchar
  state char
  postal_code varchar
  phone varchar
  email varchar 
}

Ref: bookstore.author.author_id < bookstore.book.author_id
Ref: bookstore.publisher.publisher_id < bookstore.book.publisher_id
