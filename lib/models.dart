/// Data model key constants used for local map-based persistence.
/// Centralizes all database and schema string keys to prevent typos.
library;

/// Field keys for individual settings or preferences.
class SettingsKeys {
  static const String boxName = 'settings_box';
  static const String geminiApiKey = 'gemini_api_key';
  static const String isDarkMode = 'is_dark_mode';
}

/// Field keys for document metadata or content.
class DocumentKeys {
  static const String boxName = 'documents_box';
  static const String id = 'id';
  static const String title = 'title';
  static const String content = 'content';
  static const String createdAt = 'created_at';
}
