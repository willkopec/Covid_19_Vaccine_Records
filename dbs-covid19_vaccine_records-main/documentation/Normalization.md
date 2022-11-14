1. First Normal Form: 
For first normal form, we verified all entities and tables had a primary key. For example, our table/entity patient has the columns first_name, last_name, dob, gender, type_1, and p_phone_num all depend on the primary key patient_id.
   
2. Second Normal Form:
For second normal form, we verified that all non key columns depend on a whole primary key. For example, our table contact, the non key columns of email_address and phone_num depend on the whole primary key patient_id, so the table is in second normal form.
    
3. Third Normal From:
For third normal form, we verified that for all tables, all non-key columns only depended on primary key columns, and not any other non-key columns. For our tables, the non-key columns depend on the whole key.

4. Boyce-Codd Normal Form:
For Boyce-Codd normal form, we verified that all tables had non-key columns depending on non-key columns, or key columns depending on non-key columns. We also verified that there was no redundency between columns
