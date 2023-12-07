[#ftl]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: url("https://source.unsplash.com/blue-and-pink-light-illustration-LeG68PrXA6Y") no-repeat center center fixed;
            background-size: cover;
            align-items: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
            height: 100vh;
            padding-top: 50px;
            padding-bottom: 50px;
        }

        h5 {
            font-style: italic;
        }

        .detail-container {
            width: 80%;
            max-width: 600px;
            background-color: #f1f9ff;
            border-radius: 5px;
            padding: 20px;
            text-align: center;
        }

        .back-btn {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="detail-container">
    <h2>${post.title}</h2>
    <h5>${post.author}</h5>
    <p>${post.body?no_esc}</p>
</div>

<a href="/" class="btn btn-secondary back-btn">Back</a>

</body>
</html>