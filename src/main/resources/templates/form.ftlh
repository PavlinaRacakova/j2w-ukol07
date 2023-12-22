[#ftl]
[#import "/spring.ftl" as spring]
<!DOCTYPE html>
<html lang="en">

[@c.header title="Editation" cssFile="style.css" /]

<body>

<div class="container">
    <h1 class="title">${title}</h1>

    <form class="form-container" action="${action}" method="post">
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" value="${(post.author)!""}">

        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${(post.title)!""}">

        <label for="perex">Perex:</label>
        <input type="text" id="perex" name="perex" value="${(post.perex)!""}">

        <label for="body">Body:</label>
        <textarea id="body" name="body">${(post.body)!""}</textarea>

        <div class="submit-btn">
            <input type="submit" value="Submit" class="btn btn-primary">
        </div>
    </form>
</div>

</body>
</html>