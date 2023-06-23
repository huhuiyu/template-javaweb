# javaweb项目演示模板

## 项目目录

- [java后端项目目录](/javaweb/)
  - [项目说明](/javaweb/README.md)
- [前端调用测试项目目录](/web-test/)
- [maven配置阿里云仓库](./settings.xml)

## idea配置说明

- 乱码问题：
  - 控制台设置：打开`Help->Edit Custom VM options...`菜单，添加内容：`-Dfile.encoding=UTF-8`
  - 单个项目设置：打开`File->Settings...`菜单，选择：`Editor->File Encodings`选项，将所有的`Encoding`选项设置为`UTF-8`
  - 新项目设置：打开`File->New Projects Setup->Settings For New Projects...`菜单，选择：`Editor->File Encodings`选项，将所有的`Encoding`选项设置为`UTF-8`
- 项目编译等级设置：
  - 打开`File->Project Structure...`菜单，选择：`Project`选项，将`Language level`选项修改为合适的等级，例如`8`
