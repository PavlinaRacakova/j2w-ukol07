[#ftl]

[#macro pagerBox postList]
    <div class="pager">
        [@pager.pagerLink page=postList.number - 1 linkCanContinue=postList.hasPrevious() text=" 🢀 " /]
        [@pager.pagerLink page=postList.number + 1 linkCanContinue=postList.hasNext() text=" 🢂 " /]
    </div>
[/#macro]

[#macro pagerLink page text linkCanContinue]
    [#if linkCanContinue]
        <a href="${createURL({"size": postList.size, "page": page})}" class="page">${text}</a>
    [#else ]
        <span class="page cannotContinue">${text}</span>
    [/#if]
[/#macro]