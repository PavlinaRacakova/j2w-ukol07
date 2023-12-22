[#ftl]
<!DOCTYPE html>
<html lang="en">

[@c.header title="Detail" cssFile="style.css" /]

<body>

<div class="detail-container">
    <h2>${post.title}</h2>
    <h5>${post.author}</h5>
    <p>${post.body?no_esc}</p>
</div>

<a href="/" class="btn btn-secondary back-btn">Back</a>

</body>
</html>