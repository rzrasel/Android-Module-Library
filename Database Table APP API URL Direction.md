### Database Table "APP API URL Direction" Design
**"APP API URL Direction" table as follows**

* MySQL Table Name: prefix_tbl_app_api_url_derection

| Column Name | Data Type | Length | Is Null |
| ------ | ------ | ------ | ------ |
| taap_project_id | BIGINT | 20 | ✕ |
| taaud_url_id | BIGINT | 20 | ✕ |
| taaud_url_key | VARCHAR | 255 | ✕ |
| taaud_url_value | VARCHAR | 255 | ✕ |
| taaud_url_status | BOOLEAN |  | ✕ |
| taaud_url_create_date | DATETIME |  | ✕ |
| taaud_url_modify_date | DATETIME |  | ✕ |
| taaud_url_created_by | BIGINT | 20 | ✓ |
| taaud_url_modified_by | BIGINT | 20 | ✓ |

* Drop Table

```drop_table_app_api_url_derection
DROP TABLE IF EXISTS prefix_tbl_app_api_url_derection;
```

* Create Table

```create_table_app_api_url_derection
CREATE TABLE IF NOT EXISTS prefix_tbl_app_api_url_derection (
    taap_project_id                 BIGINT(20)      NOT NULL,
    taaud_url_id                    BIGINT(20)      NOT NULL,
    taaud_url_key                   VARCHAR(255)    NOT NULL,
    taaud_url_value                 VARCHAR(255)    NOT NULL,
    taaud_url_status                BOOLEAN         NOT NULL,
    taaud_url_create_date           DATETIME        NOT NULL,
    taaud_url_modify_date           DATETIME        NOT NULL,
    taaud_url_created_by            BIGINT(20)      NULL,
    taaud_url_modified_by           BIGINT(20)      NULL,
    CONSTRAINT pk_app_api_url_derection_taaud_url_id PRIMARY KEY (taaud_url_id),
    CONSTRAINT fk_app_project_taap_project_id FOREIGN KEY (taap_project_id) REFERENCES prefix_tbl_app_api_project(taap_project_id)
);
```


[Rz Rasel]
