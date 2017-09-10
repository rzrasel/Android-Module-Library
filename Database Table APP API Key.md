### Database Table APP Project Design
**APP Project table as follows**

* MySQL Table Name: prefix_tbl_app_project

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| tap_project_id | BIGINT | 20 | ✕ |
| tap_project_name | VARCHAR | 255 | ✕ |
| tap_project_details | TEXT |  | ✓ |
| tap_project_package_bundle | VARCHAR | 255 | ✕ |
| tap_project_latest_ver_code | VARCHAR | 255 | ✕ |
| tap_project_latest_ver_name | VARCHAR | 255 | ✕ |
| tap_project_last_valid_ver_code | VARCHAR | 255 | ✕ |
| tap_project_last_valid_ver_name | VARCHAR | 255 | ✕ |
| tap_project_status | BOOLEAN |  | ✕ |
| tap_project_create_date | DATETIME |  | ✕ |
| tap_project_modify_date | DATETIME |  | ✕ |
| tap_project_created_by | BIGINT | 20 | ✓ |
| tap_project_modified_by | BIGINT | 20 | ✓ |

* Drop Table

```drop_table_metadata
DROP TABLE IF EXISTS prefix_tbl_app_project;
```

* Create Table

```create_table_app_project
CREATE TABLE IF NOT EXISTS prefix_tbl_app_project (
    tap_project_id                  BIGINT(20)      NOT NULL,
    tap_project_name                VARCHAR(255)    NOT NULL,
    tap_project_details             TEXT            NULL,
    tap_project_package_bundle      VARCHAR(255)    NOT NULL,
    tap_project_latest_ver_code     VARCHAR(255)    NOT NULL,
    tap_project_latest_ver_name     VARCHAR(255)    NOT NULL,
    tap_project_last_valid_ver_code VARCHAR(255)    NOT NULL,
    tap_project_last_valid_ver_name VARCHAR(255)    NOT NULL,
    tap_project_status              BOOLEAN         NOT NULL,
    tap_project_create_date         DATETIME        NOT NULL,
    tap_project_modify_date         DATETIME        NOT NULL,
    tap_project_created_by          BIGINT(20)      NULL,
    tap_project_modified_by         BIGINT(20)      NULL,
    CONSTRAINT pk_app_project_tap_project_id PRIMARY KEY (tap_project_id)
);
```

[Rz Rasel]
