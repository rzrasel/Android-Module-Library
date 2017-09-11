### Database Table "Metadata" Design
**"Metadata" table as follows**

* MySQL Table Name: prefix_tbl_metadata

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| tm_meta_ref_id | BIGINT | 20 | ✓ |
| tm_meta_id | BIGINT | 20 | ✕ |
| tm_meta_identity | VARCHAR | 64 | ✓ |
| tm_meta_key | VARCHAR | 255 | ✕ |
| tm_meta_value | TEXT |  | ✓ |
| tm_meta_create_date | DATETIME |  | ✕ |
| tm_meta_modify_date | DATETIME |  | ✕ |
| tm_meta_created_by | BIGINT | 20 | ✓ |
| tm_meta_modified_by | BIGINT | 20 | ✓ |


* Drop Table

```drop_table_metadata
DROP TABLE IF EXISTS prefix_tbl_metadata;
```

* Create Table

```create_table_metadata
CREATE TABLE IF NOT EXISTS prefix_tbl_metadata (
    tm_meta_ref_id                  BIGINT(20)      NULL,
    tm_meta_id                      BIGINT(20)      NOT NULL,
    tm_meta_identity                VARCHAR(64)     NULL,
    tm_meta_key                     VARCHAR(255)    NOT NULL,
    tm_meta_value                   TEXT            NULL,
    tm_meta_create_date             DATETIME        NOT NULL,
    tm_meta_modify_date             DATETIME        NOT NULL,
    tm_meta_created_by              BIGINT(20)      NULL,
    tm_meta_modified_by             BIGINT(20)      NULL,
    CONSTRAINT pk_metadata_tm_meta_id PRIMARY KEY (tm_meta_id)
);
```

### Metadata Property

| Reference ID | Meta ID | Meta Identity | Key | Value |
| ------ | ------ | ------ | ------ | ------ |
| taap_project_id | id | tbl_app_api_project | app_update_msg | Your application must need to update for use.\n\nWe are always try to sarve you. Please stay with us |

[Rz Rasel]
