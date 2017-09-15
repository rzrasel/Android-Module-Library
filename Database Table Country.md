### Database Table "Country" Design
**"Country" table as follows**

* MySQL Table Name: prefix_tbl_country

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
DROP TABLE IF EXISTS prefix_tbl_country;
```

* Create Table

```create_table_metadata
CREATE TABLE IF NOT EXISTS prefix_tbl_country (
    tcoun_country_id                BIGINT(20)      UNSIGNED NOT NULL,
    tcoun_country_name              VARCHAR(255)    NOT NULL COLLATE utf8_unicode_ci,
    tcoun_country_native_name       VARCHAR(255)    NULL COLLATE utf8_unicode_ci,
    tcoun_country_iso_alpha_two     VARCHAR(255)    NOT NULL COLLATE utf8_unicode_ci,
    tcoun_country_iso_alpha_three   VARCHAR(255)    NULL COLLATE utf8_unicode_ci,
    tcoun_country_iso_numeric_code  VARCHAR(255)    NULL COLLATE utf8_unicode_ci,
    tcoun_country_create_date       DATETIME        NOT NULL,
    tcoun_country_modify_date       DATETIME        NOT NULL,
    tcoun_country_created_by        BIGINT(20)      UNSIGNED NULL,
    tcoun_country_modified_by       BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_country_tcoun_country_id PRIMARY KEY (tcoun_country_id)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```


[Rz Rasel]
