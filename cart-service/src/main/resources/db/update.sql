UPDATE products
SET CATEGORY_ID = :category, 
    TITLE = :title, 
    PRICE = :price, 
    DESCRIPTION = :description, 
    UPDATED_AT = CURRENT_TIMESTAMP
WHERE ID = :id;
