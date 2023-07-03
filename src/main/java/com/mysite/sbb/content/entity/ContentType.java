@Entity
@Table(name = "content_type")
@SQLDelete(sql = "UPDATE content_type SET deleted_at = CURRENT_TIMESTAMP WHERE content_type_id = ?")
@Where(clause = "deleted_at IS NULL")
public class ContentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_type_id")
    private Long contentTypeId;

    @Column(name = "content_type_name", unique = true, length = 100)
    private String contentTypeName;

    @OneToMany(mappedBy = "contentType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ContentBodySchema> contentBodySchema;

    @Column(name = "deleted_at")
    private Date deletedAt;

    // Getters and Setters

    public Long getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(Long contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getContentTypeName() {
        return contentTypeName;
    }

    public void setContentTypeName(String contentTypeName) {
        this.contentTypeName = contentTypeName;
    }

    public List<ContentBodySchema> getContentBodySchema() {
        return contentBodySchema;
    }

    public void setContentBodySchema(List<ContentBodySchema> contentBodySchema) {
        this.contentBodySchema = contentBodySchema;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
