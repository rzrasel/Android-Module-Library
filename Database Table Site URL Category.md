### Database Table "APP API Key" Design
**"APP API Key" table as follows**

* MySQL Table Name: prefix_tbl_app_api_key

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| taap_project_id | BIGINT | 20 | ✕ |
| taak_api_id | BIGINT | 20 | ✕ |
| taak_api_auth_key | VARCHAR | 255 | ✕ |
| taak_api_key_type | VARCHAR | 255 | ✕ |
| taak_api_usage_type | VARCHAR | 255 | ✕ |
| taak_api_status | BOOLEAN |  | ✕ |
| taak_api_create_date | DATETIME |  | ✕ |
| taak_api_modify_date | DATETIME |  | ✕ |
| taak_api_created_by | BIGINT | 20 | ✓ |
| taak_api_modified_by | BIGINT | 20 | ✓ |

* Drop Table

```drop_table_app_api_key
DROP TABLE IF EXISTS prefix_tbl_site_url_category;
```

* Create Table

```create_table_site_url_category
CREATE TABLE IF NOT EXISTS prefix_tbl_site_url_category (
    tsuc_group_id                   BIGINT(20)      UNSIGNED NOT NULL,
    tsuc_group_name                 VARCHAR(255)    NOT NULL,
    tsuc_group_slug                 VARCHAR(255)    NOT NULL COLLATE utf8_unicode_ci,
    tsuc_group_status               BOOLEAN         NOT NULL,
    tsuc_group_create_date          DATETIME        NOT NULL,
    tsuc_group_modify_date          DATETIME        NOT NULL,
    tsuc_group_created_by           BIGINT(20)      UNSIGNED NULL,
    tsuc_group_modified_by          BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_site_url_cat_tsuc_group_id PRIMARY KEY (tsuc_group_id),
    CONSTRAINT uk_site_url_cat_tsuc_group_slug UNIQUE KEY (tsuc_group_slug)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```

[Rz Rasel]
