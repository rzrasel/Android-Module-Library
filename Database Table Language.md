### Database Table "Language" Design
**"Language" table as follows**

* MySQL Table Name: prefix_tbl_language

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

```drop_table_language
DROP TABLE IF EXISTS prefix_tbl_language;
```

* Create Table


```create_table_language
CREATE TABLE IF NOT EXISTS prefix_tbl_language (
    tlan_lan_id                     BIGINT(20)      UNSIGNED NOT NULL,
    tlan_lan_name                   VARCHAR(255)    NOT NULL COLLATE utf8_unicode_ci,
    tlan_lan_native_name            VARCHAR(255)    NULL COLLATE utf8_unicode_ci,
    tlan_lan_culture_name           VARCHAR(255)    NULL COLLATE utf8_unicode_ci,
    tlan_lan_iso_alpha_two          VARCHAR(255)    NOT NULL COLLATE utf8_unicode_ci,
    tlan_lan_iso_alpha_three        VARCHAR(255)    NULL COLLATE utf8_unicode_ci,
    tlan_lan_create_date            DATETIME        NOT NULL,
    tlan_lan_modify_date            DATETIME        NOT NULL,
    tlan_lan_created_by             BIGINT(20)      UNSIGNED NULL,
    tlan_lan_modified_by            BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_language_tlan_lan_id PRIMARY KEY (tlan_lan_id)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```


[Rz Rasel]
