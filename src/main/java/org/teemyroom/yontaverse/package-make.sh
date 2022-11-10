domains="auth clue place plot problem"
# for domain in $domains
# do
#     mkdir $domain
# done

for domain in $domains
do
    cd $domain
    mkdir application
    mkdir presentation
    mkdir domain
    cd domain
    Domain=$(echo $domain | awk '{ print toupper(substr($0, 1, 1)) substr($0, 2) }')
    (cat << EOF > ${Domain}.java
package org.teemyroom.yontaverse.$domain.domain;

import org.teemyroom.yontaverse.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ${Domain} extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
EOF
    )
    (cat << EOF > ${Domain}Repository.java
package org.teemyroom.yontaverse.$domain.domain;

import org.teemyroom.yontaverse.common.BaseRepository;

public interface ${Domain}Repository extends BaseRepository<${Domain}> {}
EOF
    )
    (cat << EOF > ${Domain}CommandService.java
package org.teemyroom.yontaverse.$domain.domain;

import org.teemyroom.yontaverse.common.BaseCommandService;
import org.springframework.stereotype.Service;

@Service
public class ${Domain}CommandService extends BaseCommandService<${Domain}> {
    
    public ${Domain}CommandService(${Domain}Repository ${domain}Repository) {
        super(${domain}Repository);
    }
}
EOF
    )
    (cat << EOF > ${Domain}QueryService.java
package org.teemyroom.yontaverse.$domain.domain;

import org.teemyroom.yontaverse.common.BaseQueryService;
import org.springframework.stereotype.Service;

@Service
public class ${Domain}QueryService extends BaseQueryService<${Domain}> {

    public ${Domain}QueryService(${Domain}Repository ${domain}Repository) {
        super(${domain}Repository);
    }
}
EOF
    )
    cd ../../
done