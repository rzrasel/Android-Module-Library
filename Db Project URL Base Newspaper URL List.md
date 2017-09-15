### Database Table "URL Base Newspaper URL List" Design
**"URL Base Newspaper URL List" table as follows**

* MySQL Table Name: prefix_tbl_urlbasenewppr_list

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

```drop_table_urlbasenewppr_list
DROP TABLE IF EXISTS prefix_tbl_urlbasenewppr_list;
```

* Create Table


    
    id
    page tab name
    url



```create_table_urlbasenewppr_list
CREATE TABLE IF NOT EXISTS prefix_tbl_urlbasenewppr_list (
    tubnpi_np_info_id               BIGINT(20)      UNSIGNED NOT NULL,
    tubnpl_np_list_id               BIGINT(20)      UNSIGNED NOT NULL,
    tubnpl_np_list_name             TEXT            NOT NULL COLLATE utf8_unicode_ci,
    tubnpl_np_list_url              TEXT            NULL COLLATE utf8_unicode_ci,

    tubnpl_np_list_create_date      DATETIME        NOT NULL,
    tubnpl_np_list_modify_date      DATETIME        NOT NULL,
    tubnpl_np_list_created_by       BIGINT(20)      UNSIGNED NULL,
    tubnpl_np_list_modified_by      BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_ubnp_list_tubnpl_list_id PRIMARY KEY (tubnpl_np_list_id)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```


[Rz Rasel]
