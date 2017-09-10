# Android-Module-Library
Android Module Library

### Database Metadata Table Design
**Metadata table as follows**

* MySQL Table Name: prefix_tbl_metadata

| Column Name | Data Type | Size | Is Null |
| ------ | ------ | ------ | ------ |
| tmeta_id | BIGINT | 20 | ✕ |
| tmeta_tbl_identity | VARCHAR | 64 | ✓ |
| tmeta_key | VARCHAR | 64 | ✕ |
| tmeta_value | LONGTEXT | 64 | ✓ |

* MySQL Table Create

```create_metadata_table
CREATE TABLE prefix_tbl_metadata (
    tmeta_id    BIGINT(20),
    column2 datatype,
    column3 datatype,
   ....
);
```
