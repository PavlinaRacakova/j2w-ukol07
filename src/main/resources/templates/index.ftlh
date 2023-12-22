[#ftl]
<!DOCTYPE html>
<html lang="en">

[@c.header title="Posts" cssFile="indexStyle.css" /]

<body>

<div class="admin-button">
    <a href="/admin" class="btn btn-outline-dark">Admin Page</a>
</div>

<div class="container entries">

    [#list postList.content as post]
        <div class="entry">
            <div class="entry-content">
                <h3>${post.title}</h3>
                <p><strong>Author: </strong>${post.author}</p>
                <p><strong>Date: </strong>${post.published?date?string.long}</p>
                <div class="summary">${post.perex}</div>
            </div>
            <a href="/post/${post.slug}" class="btn btn-primary read-more">Read</a>
        </div>
    [/#list]

    [@pager.pagerBox postList=postList /]

</div>

</body>
</html>