### Database Table "URL Base Newspaper Info" Design
**"URL Base Newspaper Info" table as follows**

* MySQL Table Name: prefix_tbl_urlbasenewppr_info

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

```drop_table_urlbasenewppr_info
DROP TABLE IF EXISTS prefix_tbl_urlbasenewppr_info;
```

* Create Table

```create_table_urlbasenewppr_info
CREATE TABLE IF NOT EXISTS prefix_tbl_urlbasenewppr_info (
    clr_ref_id                      BIGINT(20)      UNSIGNED NOT NULL,
    tubnpi_np_info_id               BIGINT(20)      UNSIGNED NOT NULL,
    tubnpi_np_info_name             TEXT            NOT NULL COLLATE utf8_unicode_ci,
    tubnpi_np_info_home_url         TEXT            NULL COLLATE utf8_unicode_ci,
    tubnpi_np_info_status           BOOLEAN         NOT NULL,
    tubnpi_np_info_show_pub         BOOLEAN         NOT NULL     COMMENT "Is Show At APP Published Time",
    tubnpi_np_info_create_date      DATETIME        NOT NULL,
    tubnpi_np_info_modify_date      DATETIME        NOT NULL,
    tubnpi_np_info_created_by       BIGINT(20)      UNSIGNED NULL,
    tubnpi_np_info_modified_by      BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_ubnp_info_tubnpi_info_id PRIMARY KEY (tubnpi_np_info_id)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```


[Rz Rasel]
