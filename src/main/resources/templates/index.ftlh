[#ftl]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Posts</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url("https://source.unsplash.com/blue-and-pink-light-illustration-LeG68PrXA6Y") no-repeat center center fixed;
            background-size: cover;
            align-items: center;
            padding-top: 50px;
            padding-bottom: 50px;
        }

        .entries {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
            justify-content: center;
            padding: 0 20px;
        }

        .entry {
            padding: 15px;
            background-color: #f1f9ff;
            border-radius: 5px;
            position: relative;
            display: flex;
            flex-direction: column;
            width: 350px;
            height: 300px;
        }

        .entry-content {
            flex-grow: 1;
        }

        .read-more {
            margin-top: 15px;
            width: 100%;
        }

        .container.entries {
            position: relative;
            min-height: 100vh;
            padding-bottom: 60px;
        }

        .pager {
            position: absolute;
            bottom: 20px; /* Adjust the distance from the bottom */
            left: 50%;
            transform: translateX(-50%);
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 24px;
        }

        .page {
            margin: 0 5px;
            text-decoration: none;
            color: #000;
        }

        .page.active {
            color: #c0bcbc;
        }
    </style>
</head>
<body>

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

    <div class="pager">
        [@pager.pagerLink page=postList.number - 1 active=postList.first text=" 🢀 " /]
        [@pager.pagerLink page=postList.number + 1 active=postList.last text=" 🢂 " /]
    </div>

</div>

</body>
</html>