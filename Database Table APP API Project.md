### Database Table "APP API Project" Design
**"APP API Project" table as follows**

* MySQL Table Name: prefix_tbl_app_api_project

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| taap_project_id | BIGINT | 20 | ✕ |
| taap_project_name | VARCHAR | 255 | ✕ |
| taap_project_details | TEXT |  | ✓ |
| taap_project_package_bundle | VARCHAR | 255 | ✕ |
| taap_project_latest_ver_code | VARCHAR | 255 | ✕ |
| taap_project_latest_ver_name | VARCHAR | 255 | ✕ |
| taap_project_lowest_valid_code | VARCHAR | 255 | ✕ |
| taap_project_lowest_valid_name | VARCHAR | 255 | ✕ |
| taap_project_status | BOOLEAN |  | ✕ |
| taap_project_create_date | DATETIME |  | ✕ |
| taap_project_modify_date | DATETIME |  | ✕ |
| taap_project_created_by | BIGINT | 20 | ✓ |
| taap_project_modified_by | BIGINT | 20 | ✓ |

* Drop Table

```drop_table_app_api_project
DROP TABLE IF EXISTS prefix_tbl_app_api_project;
```

* Create Table

```create_table_app_project
CREATE TABLE IF NOT EXISTS prefix_tbl_app_api_project (
    taap_project_id                 BIGINT(20)      NOT NULL,
    taap_project_name               VARCHAR(255)    NOT NULL,
    taap_project_details            TEXT            NULL,
    taap_project_package_bundle     VARCHAR(255)    NOT NULL,
    taap_project_latest_ver_code    VARCHAR(255)    NOT NULL,
    taap_project_latest_ver_name    VARCHAR(255)    NOT NULL,
    taap_project_lowest_valid_code  VARCHAR(255)    NOT NULL,
    taap_project_lowest_valid_name  VARCHAR(255)    NOT NULL,
    taap_project_status             BOOLEAN         NOT NULL,
    taap_project_create_date        DATETIME        NOT NULL,
    taap_project_modify_date        DATETIME        NOT NULL,
    taap_project_created_by         BIGINT(20)      NULL,
    taap_project_modified_by        BIGINT(20)      NULL,
    CONSTRAINT pk_app_api_project_taap_project_id PRIMARY KEY (taap_project_id)
);
```

### APP Project Metadata Property

| Reference ID | Meta ID | Meta Identity | Key | Value |
| ------ | ------ | ------ | ------ | ------ |
| taap_project_id | id | tbl_app_api_project | app_update_msg | Your application must need to update for use.\n\nWe are always try to sarve you. Please stay with us |
| taap_project_id | id | tbl_app_api_project | admob_interstitial_repeat_millis | 1000 * 60 * rand(4, 7) |
| taap_project_id | id | tbl_app_api_project | admob_interstitial_status | BOOLEAN |
| taap_project_id | id | tbl_app_api_project | admob_banner_status | BOOLEAN |

[Rz Rasel]
