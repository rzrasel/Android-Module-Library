### Database Table "Country Language Reference" Design
**"Country Language Reference" table as follows**

* MySQL Table Name: prefix_tbl_con_lan_ref

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

```drop_table_con_lan_ref
DROP TABLE IF EXISTS prefix_tbl_con_lan_ref;
```

* Create Table

```create_table_con_lan_ref
CREATE TABLE IF NOT EXISTS prefix_tbl_con_lan_ref (
    tcoun_country_id                BIGINT(20)      UNSIGNED NOT NULL,
    tlan_lan_id                     BIGINT(20)      UNSIGNED NOT NULL,
    clr_ref_id                      BIGINT(20)      UNSIGNED NOT NULL,
    clr_ref_create_date             DATETIME        NOT NULL,
    clr_ref_modify_date             DATETIME        NOT NULL,
    clr_ref_created_by              BIGINT(20)      UNSIGNED NULL,
    clr_ref_modified_by             BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_con_lan_ref_clr_ref_id PRIMARY KEY (clr_ref_id)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```


[Rz Rasel]
