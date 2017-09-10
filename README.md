# Android-Module-Library
Android Module Library

### Database Metadata Table Design
**Metadata table as follows**

* MySQL Table Name: prefix_tbl_metadata

| Column Name | DataType | Size |
| ------ | ------ | ------ |
| tmeta_id | BIGINT | 20 |

* MySQL Table Create

```create_metadata_table
CREATE TABLE prefix_tbl_metadata (
    tmeta_id    BIGINT(20),
    column2 datatype,
    column3 datatype,
   ....
);
```
