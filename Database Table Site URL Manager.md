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
DROP TABLE IF EXISTS prefix_tbl_site_url_manager;
```

* Create Table

* Site URL Manager
    * css before (json arra > array(css =>array(class => values, id => values, inline => values), javascript =>array(), html => array())
    * css after (json arra > array(css =>array(class => values, id => values, inline => values), javascript =>array(), html => array())
    * meta content
    * meta description
    * View Permission (public / private $is_logged_in)
    * target

```create_table_site_url_manager
CREATE TABLE IF NOT EXISTS prefix_tbl_site_url_manager (
    tsuc_group_id                   BIGINT(20)      UNSIGNED NOT NULL,
    tsum_url_id                     BIGINT(20)      UNSIGNED NOT NULL,
    tsum_url_parent_id              BIGINT(20)      UNSIGNED NULL,
    tsum_url_name                   TEXT            NOT NULL COLLATE utf8_unicode_ci,
    tsum_url_slug                   TEXT            NULL COLLATE utf8_unicode_ci,
    tsum_url_order                  BIGINT(20)      UNSIGNED NOT NULL,
    tsum_url_status                 BOOLEAN         NOT NULL,
    tsum_url_create_date            DATETIME        NOT NULL,
    tsum_url_modify_date            DATETIME        NOT NULL,
    tsum_url_created_by             BIGINT(20)      UNSIGNED NULL,
    tsum_url_modified_by            BIGINT(20)      UNSIGNED NULL,
    CONSTRAINT pk_site_url_manager_tsum_url_id PRIMARY KEY (tsum_url_id)
) ENGINE=InnoDB DEFAULT COLLATE utf8_unicode_ci;
```


[Rz Rasel]
