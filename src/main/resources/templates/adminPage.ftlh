[#ftl]
<!DOCTYPE html>
<html lang="en">

[@c.header title="Administrative" cssFile="style.css" /]

<body>

<div class="container">

    <div>
        <a href="/" class="btn btn-info back-home">Back Home</a>
        <a href="/new" class="btn btn-success create-new">Create New</a>
    </div>

    <table class="entry-table table">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Date</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        [#list postList.content as post]
            <tr class="entry">
                <td>${post.title}</td>
                <td>${post.author}</td>
                <td>${post.published?date?string.long}</td>
                <td class="entry-buttons">
                    <a href="/edit/${post.slug}" class="btn btn-primary edit-btn">Edit</a>
                    <form method="post" action="/delete">
                        <input type="hidden" name="id" value="${post.id}"/>
                        <button class="btn btn-danger delete-btn">Delete</button>
                    </form>
                </td>
            </tr>
        [/#list]
        </tbody>
    </table>

    [@pager.pagerBox postList=postList /]

</div>

</body>
</html>