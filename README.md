# Getting Started

### Init

* [Generate Gmail password](https://support.google.com/accounts/answer/185833?hl=en)
* In file ./jmail-tracker/src/main/resources/application.properties set spring.mail.username
 and spring.mail.password

#### Endpoint

* */mailService/send* -> This service send and track an email returning his id and if an attachment is present it will
return also his impact. Handled attachments are: null, 5, 10, 20 they refer files already included in project
* *mailService/getStats* --> This service has no input , and returns stats (min, max, avg) about sent mails.

####Postman

You can find a collection here ./jmail-tracker/src/main/resources/postmancollection
