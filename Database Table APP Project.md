### Database Table APP Project Design
**APP Project table as follows**

* MySQL Table Name: prefix_tbl_app_project

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| reference_id | BIGINT | 20 | ✕ |
| tmeta_id | BIGINT | 20 | ✕ |
| tmeta_tbl_identity | VARCHAR | 64 | ✓ |
| tmeta_key | VARCHAR | 255 | ✕ |
| tmeta_value | TEXT |  | ✓ |
| tmeta_create_date | DATETIME |  | ✕ |
| tmeta_modify_date | DATETIME |  | ✕ |
| tmeta_created_by | BIGINT | 20 | ✓ |
| tmeta_modified_by | BIGINT | 20 | ✓ |


* Drop Table

```drop_table_metadata
DROP TABLE IF EXISTS prefix_tbl_app_project;
```

* Create Table

```create_table_metadata
CREATE TABLE IF NOT EXISTS prefix_tbl_app_project (
    reference_id            BIGINT(20)      NOT NULL,
    tmeta_id                BIGINT(20)      NOT NULL,
    tmeta_tbl_identity      VARCHAR(64)     NULL,
    tmeta_key               VARCHAR(255)    NOT NULL,
    tmeta_value             TEXT            NULL,
    tmeta_create_date       DATETIME        NOT NULL,
    tmeta_modify_date       DATETIME        NOT NULL,
    tmeta_created_by        BIGINT(20)      NULL,
    tmeta_modified_by       BIGINT(20)      NULL,
    CONSTRAINT pk_metadata_tmeta_id PRIMARY KEY (tmeta_id)
);
```

[Rz Rasel]
