-- Zadatak 1
SELECT first_name, last_name, email, street, number, Place.name as place_name, zip_code, Country.name as country_name 
	FROM User left join Address on User.Address_id = Address.id
	left join Place on Address.Place_id = Place.id
    left join Country on Place.Country_id = Country.id
    order by country_name, place_name, last_name, first_name;

-- Zadatak 2
select *
    from User left join ShoppingCartItem on User.id = ShoppingCartItem.User_id
    left join Product on ShoppingCartItem.Product_id = Product.id
    where User.id = 1;

-- zadatak 3 
select * 
    from product left join shoppingcartitem on product.id = shoppingcartitem.product_id
    left join user on user.id = shoppingcartitem.user_id
    left join address on address.id = user.address_id
    left join place on place.id = address.place_id
    left join country on country.id = place.country_id
    where country.code = 'rs';

-- zadatak 4
select User.first_name, User.last_name, Country.name as country_name from ShoppingCartItem
    left join Product on Product.id = ShoppingCartItem.Product_id
    left join User on ShoppingCartItem.User_id = User.id
    left join Address on User.Address_id = Address.id
    left join Place on Address.Place_id = Place.id
    left join Country on Place.Country_id = Country.id
    where Country.code = "ch";

-- zadatak 5
select sum(ShoppingCartItem.count) as number_of_products, User.first_name, User.last_name from ShoppingCartItem
    left join User on ShoppingCartItem.User_id = User.id
    left join Product on ShoppingCartItem.Product_id = Product.id
    group by User.id 
    order by number_of_products desc;

-- zadatak 6
select * from User 
    left join Address on User.Address_id = Address.id
    left join Place on Address.Place_id = Place.id
    where Place.id is null
    and Address.id is not null;

-- zadatak 7
select * from User
    left join ShoppingCartItem on ShoppingCartItem.User_id = User.id
    where ShoppingCartItem.id is null;

-- zadatak 8
select * from Product
    left join ShoppingCartItem on ShoppingCartItem.Product_id = Product.id
    where ShoppingCartItem.id is null;

-- zadatak 9
SELECT sum(ShoppingCartItem.count) as number_of_products, country.name as country_name from     
    ShoppingCartItem left join User on ShoppingCartItem.User_id = User.id
    left join Address on User.Address_id = Address.id
    left join Place on Address.Place_id = Place.id
    left join Country on Place.Country_id = Country.id
    where Country.id is not null
    group by Country.id
    order by number_of_products desc;

-- zadatak 10
SELECT count(User.id) as number_of_Users, Country.name from 	
	User left join Address on User.Address_id = Address.id
	left join Place on Address.Place_id = Place.id
    left join Country on Place.Country_id = Country.id
    where Country.name IS not null
    group by Country.name
    order by number_of_Users desc;

-- zadatak 11
SELECT sum(ShoppingCartItem.count*Product.price) as total_amount, Country.name as country_name from     
    ShoppingCartItem left join User on ShoppingCartItem.User_id = User.id
    left join Product on ShoppingCartItem.Product_id = Product.id
    left join Address on User.Address_id = Address.id
    left join Place on Address.Place_id = Place.id
    left join Country on Place.Country_id = Country.id
    where Country.id is not null
    group by Country.id
    order by total_amount desc;


