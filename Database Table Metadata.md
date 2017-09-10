
### Database Metadata Table Design
**Metadata table as follows**

* MySQL Table Name: prefix_tbl_metadata

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| tmeta_id | BIGINT | 20 | ✕ |
| tmeta_tbl_identity | VARCHAR | 64 | ✓ |
| tmeta_key | VARCHAR | 255 | ✕ |
| tmeta_value | TEXT | 64 | ✓ |
| tmeta_create_date | DATETIME |  | ✕ |
| tmeta_modify_date | DATETIME |  | ✕ |
| tmeta_created_by | BIGINT | 20 | ✓ |
| tmeta_modified_by | BIGINT | 20 | ✓ |


* Drop Table

```drop_metadata_table
DROP TABLE IF EXISTS prefix_tbl_metadata;
```

* Create Table

```create_metadata_table
CREATE TABLE IF NOT EXISTS prefix_tbl_metadata (
    tmeta_id                BIGINT(20)   NOT NULL,
    tmeta_tbl_identity      VARCHAR(64) NULL,
    tmeta_key               VARCHAR(255)    NOT NULL,
    tmeta_value TEXT,
    tmeta_create_date       DATETIME     NOT NULL,
    tmeta_modify_date       DATETIME     NOT NULL,
    tmeta_created_by        BIGINT(20)  NULL,
    tmeta_modified_by       BIGINT(20)  NULL,
    CONSTRAINT pk_metadata_tmeta_id PRIMARY KEY (tmeta_id)
);
```

[Rz Rasel]